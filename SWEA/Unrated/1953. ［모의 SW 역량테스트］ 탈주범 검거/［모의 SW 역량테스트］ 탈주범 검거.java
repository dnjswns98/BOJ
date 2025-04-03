import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static int n, m, r, c, l;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] tunnel = { 
			{ -1 },
			{ 0, 1, 2, 3 }, // 상하좌우
			{ 0, 1 }, // 상하
			{ 2, 3 }, // 좌우
			{ 0, 3 }, // 상우
			{ 1, 3 }, // 하우
			{ 1, 2 }, // 하좌
			{ 0, 2 } // 상좌
	};

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
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visited = new boolean[n][m];
			visited[r][c] = true;

			Deque<Point> dq = new ArrayDeque<>();
			dq.add(new Point(r, c, 1)); // 시작점
			int cnt = 0;
			while (!dq.isEmpty()) {
				Point cur = dq.poll();

				if (cur.dist == l + 1) { // 지정된 시간까지 탐색을 모두 완료했다면
					break;
				}
				
				cnt++;

				int dir = arr[cur.x][cur.y];
				for (int i = 0; i < tunnel[dir].length; i++) { // 터널 모양에 맞게 다음 탐색
					int nx = cur.x + dx[tunnel[dir][i]];
					int ny = cur.y + dy[tunnel[dir][i]];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (visited[nx][ny] || arr[nx][ny] == 0) continue;

					boolean check = false;
					int nextDir = arr[nx][ny]; // 다음 칸의 터널 방향
					for (int d : tunnel[nextDir]) { // 다음 칸에서 갈 수 있는 방향 검사
						if (nx + dx[d] == cur.x && ny + dy[d] == cur.y) {
							check = true;
							break;
						}
					}
					
					if(check) { // 현재 칸과 다음 칸의 터널이 이어져있다면
						dq.add(new Point(nx, ny, cur.dist + 1));
						visited[nx][ny] = true;
					}
				}
			}

			sb.append("#").append(t).append(" ");
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}