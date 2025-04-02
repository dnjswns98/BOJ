import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, time;
	static int[][] arr;
	static Fish shark;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int dist;

		public Fish(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		ArrayList<Fish> fish = new ArrayList<>(); // 물고기 저장
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					shark = new Fish(i, j); // 아기 상어 위치 저장
					arr[i][j] = 0; // 빈공간으로 처리
				}
			}
		}

		time = 0;
		int size = 2;
		int eat = 0;
		while (true) {
			if (bfs(shark.x, shark.y, size)) { // 먹이를 먹었다면
				if (++eat == size) { // 상어 크기만큼 먹었으면
					eat = 0;
					size++; // 사이즈업
				}
			}
			else break; // 먹이를 못찾았다면 종료
		}

		System.out.println(time);
	}

	static boolean bfs(int x, int y, int size) { // 현재 아기상어의 위치와 크기
		PriorityQueue<Fish> pq = new PriorityQueue<>(); // 거리, 높이, 위치(col) 순으로 정렬
		pq.offer(new Fish(x, y, 0));

		boolean[][] visited = new boolean[n][n];
		visited[x][y] = true; // 시작위치 방문처리

		while (!pq.isEmpty()) {
			Fish cur = pq.poll();

			if (arr[cur.x][cur.y] > 0 && arr[cur.x][cur.y] < size) { // 먹이를 찾았다면
				arr[cur.x][cur.y] = 0; // 빈 공간 만들기
				shark = new Fish(cur.x, cur.y); // 상어 위치 업데이트
				time += cur.dist;
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (visited[nx][ny] || arr[nx][ny] > size)
					continue;

				visited[nx][ny] = true;
				pq.offer(new Fish(nx, ny, cur.dist + 1));
			}
		}

		return false;
	}
}
