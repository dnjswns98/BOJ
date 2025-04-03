import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

	static int n;
	static int[][] arr;
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int dist;
		
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.dist, o.dist);
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
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					arr[i][j] = c[j] - '0';
				}
			}

			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };

			int[][] minDist = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(minDist[i], Integer.MAX_VALUE);
			}
			minDist[0][0] = 0; // 출발지

			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(0, 0, 0));

			while (!pq.isEmpty()) {
				Point cur = pq.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if(minDist[nx][ny] > cur.dist + arr[nx][ny]) {
						minDist[nx][ny] = cur.dist + arr[nx][ny];
						pq.add(new Point(nx, ny, minDist[nx][ny]));
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			sb.append(minDist[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}