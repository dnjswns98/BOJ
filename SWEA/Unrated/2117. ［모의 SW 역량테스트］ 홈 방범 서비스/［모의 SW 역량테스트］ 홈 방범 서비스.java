import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static int n, m;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int x;
		int y;
		int dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxCnt = 1; // 최소 1개 이상의 집이 존재함
			// 도시의 크기가 맵을 다 덮을 수 있어야하고 각 각 모서리 1개만 빼고 모두 구할 수 있는 경우도 생각해야함
			for (int size = 2; size <= n + 1; size++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						maxCnt = Math.max(maxCnt, bfs(i, j, size));
					}
				}
			}

			sb.append("#").append(t).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int x, int y, int size) {
		// 각 도시에서 최적의 운영을 찾기
		Deque<Point> dq = new ArrayDeque<>();
		dq.add(new Point(x, y, 0));
		
		boolean[][] visited = new boolean[n][n];
		visited[x][y] = true;
		
		int sum = 0; // 집이 지불할 수 있는 총 비용
		int houseCnt = 0; // 서비스 받는 집 개수
		int cost = size * size + (size - 1) * (size - 1); // 운영 비용

		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			if (arr[cur.x][cur.y] == 1) { // 집이라면
				houseCnt++;
				sum += m;
			}

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (visited[nx][ny]) continue;

				if (cur.dist < size - 1) { // 서비스 범위 내
					visited[nx][ny] = true;
					dq.add(new Point(nx, ny, cur.dist + 1));
				}
			}
		}
		
		return sum >= cost ? houseCnt : 0;
	}
}