import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	
	static class Point implements Comparable<Point>{
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j<m; j++) {
				arr[i][j] = c[j] - '0';
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		int INF = Integer.MAX_VALUE;
		int[][] minDist = new int[n][m];
		for(int i = 0; i<n; i++) {
			Arrays.fill(minDist[i], INF);
		}
		minDist[0][0] = 0;
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, 0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(p.x == n - 1 && p.y == m - 1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				
				if(minDist[nx][ny] > p.cnt + arr[nx][ny]) {
					minDist[nx][ny] = p.cnt + arr[nx][ny];
					pq.offer(new Point(nx,ny,minDist[nx][ny]));
				}
			}
		}
	}
}
