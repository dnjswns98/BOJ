import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cost;

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] minDist = new int[n][n];
			for(int i = 0; i<n; i++) {
				Arrays.fill(minDist[i], Integer.MAX_VALUE);
			}
			minDist[0][0] = arr[0][0];

			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(0, 0, arr[0][0]));

			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };

			while (!pq.isEmpty()) {
				Point cur = pq.poll();
				
				if(cur.x == n - 1 && cur.y == n - 1) break;

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					
					if(minDist[nx][ny] > cur.cost + arr[nx][ny]) {
						minDist[nx][ny] = cur.cost + arr[nx][ny];
						pq.add(new Point(nx, ny, minDist[nx][ny]));
					}
				}
			}
			
			sb.append("Problem ").append(test++).append(": ").append(minDist[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
