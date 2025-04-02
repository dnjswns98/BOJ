import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static class Point {
		int x;
		int y;
		int cnt;
		int dir; // 0: 세로, 1: 가로

		public Point(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			int x2 = Integer.parseInt(st.nextToken()) + 100;
			int y2 = Integer.parseInt(st.nextToken()) + 100;

			int[] dx = { -1, 1, 0, 0 }; // 상하좌우
			int[] dy = { 0, 0, -1, 1 };

			boolean[][][] visited = new boolean[2][201][201];
			visited[0][x1][y1] = true;
			visited[1][x1][y1] = true;

			Deque<Point> dq = new ArrayDeque<>();
			dq.add(new Point(x1, y1, 0, 0)); // 세로
			dq.add(new Point(x1, y1, 0, 1)); // 가로
			while (!dq.isEmpty()) {
				Point cur = dq.poll();

				if (cur.x == x2 && cur.y == y2) {
					System.out.println("#" + t + " " + cur.cnt);
					break;
				}

				if(cur.dir == 0) { // 가로 -> 세로
					for(int i = 0; i<2; i++) {
						int nx = cur.x + dx[i];
						int ny = cur.y + dy[i];
						
						if(nx < 0 || nx > 200 || ny < 0 || ny > 200) continue;
						if(visited[1][nx][ny]) continue;
						
						visited[1][nx][ny] = true;
						dq.offer(new Point(nx, ny, cur.cnt + 1, 1));
					}
				}
				else { // 세로 -> 가로
					for(int i = 2; i<4; i++) {
						int nx = cur.x + dx[i];
						int ny = cur.y + dy[i];
						
						if(nx < 0 || nx > 200 || ny < 0 || ny > 200) continue;
						if(visited[0][nx][ny]) continue;
						
						visited[0][nx][ny] = true;
						dq.offer(new Point(nx, ny, cur.cnt + 1, 0));
					}
				}
			}
		}
	}

}
