import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static char[][] arr;

	static class Point {
		int x;
		int y;
		int cutCnt; // 나무 자른 횟수
		int dir;
		int dist; // 조작횟수

		public Point(int x, int y, int cutCnt, int dir, int dist) {
			this.x = x;
			this.y = y;
			this.cutCnt = cutCnt;
			this.dir = dir;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cutCnt=" + cutCnt + ", dir=" + dir + ", dist=" + dist + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Point end = null;
			boolean[][][][] visited = new boolean[n][n][k + 1][4]; // x, y, 나무자른횟수, 방향
			Deque<Point> dq = new ArrayDeque<>();
			arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 'X') {
						visited[i][j][0][0] = true;
						dq.add(new Point(i, j, 0, 0, 0));
					} else if (arr[i][j] == 'Y') {
						end = new Point(i, j, 0, 0, 0);
					}
				}
			}

			int[] dx = { -1, 0, 1, 0 }; // 상우하좌
			int[] dy = { 0, 1, 0, -1 };
			int result = -1;

			while (!dq.isEmpty()) {
				Point cur = dq.poll();

				if (cur.x == end.x && cur.y == end.y) {
					result = cur.dist;
					break;
				}

				// 우회전
				int dir = (cur.dir + 1) % 4;
				if (!visited[cur.x][cur.y][cur.cutCnt][dir]) {
					visited[cur.x][cur.y][cur.cutCnt][dir] = true;
					dq.add(new Point(cur.x, cur.y, cur.cutCnt, dir, cur.dist + 1));
				}

				// 좌회전
				dir = cur.dir == 0 ? 3 : cur.dir - 1;
				if (!visited[cur.x][cur.y][cur.cutCnt][dir]) {
					visited[cur.x][cur.y][cur.cutCnt][dir] = true;
					dq.add(new Point(cur.x, cur.y, cur.cutCnt, dir, cur.dist + 1));
				}

				// 직진
				int nx = cur.x + dx[cur.dir];
				int ny = cur.y + dy[cur.dir];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				// 나무가 있지만 자를 수 있다면
				if (arr[nx][ny] == 'T' && cur.cutCnt < k && !visited[nx][ny][cur.cutCnt + 1][cur.dir]) {
					visited[nx][ny][cur.cutCnt + 1][cur.dir] = true;
					dq.add(new Point(nx, ny, cur.cutCnt + 1, cur.dir, cur.dist + 1));
				} 
				// 갈 수 있는 땅이고 가지않았다면
				else if ((arr[nx][ny] == 'G' || arr[nx][ny] == 'Y') && !visited[nx][ny][cur.cutCnt][cur.dir]) {
					visited[nx][ny][cur.cutCnt][cur.dir] = true;
					dq.add(new Point(nx, ny, cur.cutCnt, cur.dir, cur.dist + 1));
				}
			}

			sb.append("#").append(t).append(" ");
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}
