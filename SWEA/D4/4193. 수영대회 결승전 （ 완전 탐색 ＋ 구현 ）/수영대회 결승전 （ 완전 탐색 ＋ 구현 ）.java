import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

	static int n, a, b, c, d;
	static int[][] arr;

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(a, b, 0));
			int result = -1;
			boolean[][] visited = new boolean[n][n];
			visited[a][b] = true;
			while (!pq.isEmpty()) {
				Point p = pq.poll();

				if (p.x == c && p.y == d) {
					result = p.cnt;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;
					if (visited[nx][ny] || arr[nx][ny] == 1)
						continue;

					if (arr[nx][ny] == 2) {
						if (p.cnt % 3 == 2) {
							pq.add(new Point(nx, ny, p.cnt + 1));
							visited[nx][ny] = true;
						} else {
							pq.add(new Point(p.x, p.y, p.cnt + 1));
						}
					} else {
						visited[nx][ny] = true;
						pq.offer(new Point(nx, ny, p.cnt + 1));
					}
				}
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}