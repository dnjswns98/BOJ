import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[][] arr;

	static class Point {
		int x;
		int y;
		boolean fire;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] fireVisited = new int[n][m]; // 불의 방문 체크
		for (int i = 0; i < n; i++)
			Arrays.fill(fireVisited[i], -1);

		Point start = null;
		Deque<Point> dq = new ArrayDeque<>();
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'J')
					start = new Point(i, j);
				if (arr[i][j] == 'F') {
					dq.add(new Point(i, j));
					fireVisited[i][j] = 0;
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 }; // 상하좌우
		int[] dy = { 0, 0, -1, 1 };

		// 불부터 탐색
		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (arr[nx][ny] == '#' || fireVisited[nx][ny] >= 0) continue;

				fireVisited[nx][ny] = fireVisited[cur.x][cur.y] + 1;
				dq.add(new Point(nx, ny));
			}
		}

		// 사람 탐색
		int[][] visited = new int[n][m]; // 사람의 방문 체크
		for (int i = 0; i < n; i++)
			Arrays.fill(visited[i], -1);
		visited[start.x][start.y] = 0;
		
		dq = new ArrayDeque<>();
		dq.add(start);
		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위 벗어난 것은 탈출 성공
					System.out.println(visited[cur.x][cur.y] + 1);
					return;
				}
				if (arr[nx][ny] == '#' || visited[nx][ny] >= 0) continue;
				if (fireVisited[nx][ny] != -1 && visited[cur.x][cur.y] + 1 >= fireVisited[nx][ny]) // 사람보다 불이 먼저 도착했더나 동시에 도착한다면
					continue;

				visited[nx][ny] = visited[cur.x][cur.y] + 1;
				dq.add(new Point(nx, ny));
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
}