import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			Point end = null;
			Deque<Point> dq = new ArrayDeque<>();
			arr = new int[16][16];
			for (int i = 0; i < 16; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					arr[i][j] = c[j] - '0';
					if (arr[i][j] == 2) {
						dq.add(new Point(i, j));
					} else if (arr[i][j] == 3) {
						end = new Point(i, j);
					}
				}
			}

			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			int result = 0;
			boolean[][] visited = new boolean[16][16];
			while (!dq.isEmpty()) {
				Point cur = dq.poll();

				visited[cur.x][cur.y] = true;
				
				if(cur.x == end.x && cur.y == end.y) {
					result = 1;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if(nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
					if(visited[nx][ny] || arr[nx][ny] == 1) continue;
					
					visited[nx][ny] = true;
					dq.add(new Point(nx, ny));
				}
			}

			sb.append("#").append(t).append(" ");
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}
}
