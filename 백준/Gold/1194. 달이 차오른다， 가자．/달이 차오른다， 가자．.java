import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x;
		int y;
		int cnt;
		int key; // 비트마스킹으로 현재 가지고 있는 키 확인

		public Point(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Point start = null;
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == '0') {
					start = new Point(i, j, 0, 0);
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		boolean[][][] visited = new boolean[n][m][64]; // bitmasking 6bit
		visited[start.x][start.y][0] = true;

		Deque<Point> dq = new ArrayDeque<>();
		dq.add(start);
		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			if (arr[cur.x][cur.y] == '1') {
				System.out.println(cur.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (arr[nx][ny] == '#' || visited[nx][ny][cur.key])
					continue;

				if ('a' <= arr[nx][ny] && arr[nx][ny] <= 'f') {
					int key = cur.key | (1 << arr[nx][ny] - 'a');
					visited[nx][ny][key] = true;
					dq.add(new Point(nx, ny, cur.cnt + 1, key));
				} 
				else if ('A' <= arr[nx][ny] && arr[nx][ny] <= 'F') {
					if((cur.key & (1 << arr[nx][ny] - 'A')) > 0){
						visited[nx][ny][cur.key] = true;
						dq.add(new Point(nx, ny, cur.cnt + 1, cur.key));
					}
				} 
				else {
					visited[nx][ny][cur.key] = true;
					dq.add(new Point(nx, ny, cur.cnt + 1, cur.key));
				}
			}
		}
		
		System.out.println(-1);
	}
}