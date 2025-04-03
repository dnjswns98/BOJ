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
		int jump;

		public Point(int x, int y, int cost, int jump) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.jump = jump;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] visited = new boolean[k + 1][n][m]; // 점프 고려
		for(int i = 0; i <= k ; i++) { // 시작점은 모두 방문 체크
			visited[i][0][0] = true;
		}

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, 0, 0));

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int[] jump_x = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] jump_y = { -2, -1, 1, 2, 2, 1, -1, -2 };

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			// 목적지 도착
			if (cur.x == n - 1 && cur.y == m - 1) {
				System.out.println(cur.cost);
				return;
			}

			// 점프가 가능한 경우
			if (cur.jump < k) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + jump_x[i];
					int ny = cur.y + jump_y[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (arr[nx][ny] == 1)
						continue;

					if (!visited[cur.jump + 1][nx][ny]) {
						visited[cur.jump + 1][nx][ny] = true;
						pq.add(new Point(nx, ny, cur.cost + 1, cur.jump + 1));
					}
				}
			}

			// 점프x, 인접한 칸으로 이동
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (arr[nx][ny] == 1)
					continue;

				if (!visited[cur.jump][nx][ny]) {
					visited[cur.jump][nx][ny] = true;
					pq.add(new Point(nx, ny, cur.cost + 1, cur.jump));
				}
			}
		}

		System.out.println(-1);
	}
}
