import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[][] arr;

	static class Point {
		int x;
		int y;
		int cnt;
		boolean destroy;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cnt, boolean destroy) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroy = destroy;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		ArrayList<Point> wall = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == '1') // 벽이라면 위치 저장
					wall.add(new Point(i, j));
			}
		}

		Deque<Point> dq = new ArrayDeque<>();
		dq.add(new Point(0, 0, 1, false));

		// 0 : 벽 부수지 않음, 1 : 벽 부숨
		boolean[][][] visited = new boolean[2][n][m];
		visited[0][0][0] = true;
		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int result = -1;
		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			if (cur.x == n - 1 && cur.y == m - 1) {
				result = cur.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				
				if(cur.destroy) { // 벽을 이미 파괴했었다면
					// 벽을 또 부술수는 없다
					if (visited[1][nx][ny] || arr[nx][ny] == '1') continue;
					
					visited[1][nx][ny] = true;
					dq.offer(new Point(nx, ny, cur.cnt + 1, true));
				}
				else {
					if(!visited[0][nx][ny]) { // 방문하지 않았고
						if(arr[nx][ny] == '0') { // 벽이 없는 경우
							visited[0][nx][ny] = true;
							dq.offer(new Point(nx, ny, cur.cnt + 1, false));
						}
						else { // 벽 부수고 나아가기
							visited[1][nx][ny] = true;
							dq.offer(new Point(nx, ny, cur.cnt + 1, true));
						}
					}
				}
			}
		}

		System.out.println(result);
	}
}
