import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static int n, a, b, c, d;
	static int[][] arr;
	
	static class Point{
		int x;
		int y;
		int cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
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
			
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			Deque<Point> dq = new ArrayDeque<>();
			dq.add(new Point(a, b, 0));
			int result = -1;
			boolean[][] visited = new boolean[n][n];
			visited[a][b] = true;
			while(!dq.isEmpty()) {
				Point p = dq.poll();
				
				if(p.x == c && p.y == d) {
					result = p.cnt;
					break;
				}
				
				for(int i = 0; i<4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if(visited[nx][ny] || arr[nx][ny] == 1) continue;
					
					visited[nx][ny] = true;
					dq.offer(new Point(nx, ny, p.cnt + 1));
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}