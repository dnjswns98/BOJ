import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Point> dq = new ArrayDeque<>();

		Point start = null;
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'S') {
					start = new Point(i, j);
				} else if (arr[i][j] == '*') {
					dq.add(new Point(i, j));
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		int[][] dist = new int[n][m];
		dq.add(start);
		while (!dq.isEmpty()) {
			Point cur = dq.poll();
			char now = arr[cur.x][cur.y];

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 'X') continue;
				
				// 물 확산
				if (now == '*') {
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = '*';
						dq.add(new Point(nx, ny));
					}
				}
				else { // 고슴도치 이동
					if(arr[nx][ny] == 'D') { // 도착
						System.out.println(dist[cur.x][cur.y] + 1);
						return;
					}
					else if(arr[nx][ny] == '.') { // 한 칸 이동
						arr[nx][ny] = 'S';
						dist[nx][ny] = dist[cur.x][cur.y] + 1;
						dq.add(new Point(nx, ny));
					}
				}
			}
		}

		System.out.println("KAKTUS");
	}
}