import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우 대각선
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static class point {
		int x;
		int y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 맵 크기
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			// 0 0 이면 종료
			if (n == 0 && m == 0)
				return;

			// 맵 입력
			arr = new int[n][m];
			Queue<point> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 땅이라면 저장
					if (arr[i][j] == 1)
						q.offer(new point(i, j));
				}
			}

			int cnt = 0;
			visited = new boolean[n][m];
			while (!q.isEmpty()) {
				int x = q.peek().x;
				int y = q.poll().y;

				// 방문하지 않은 땅이라면 섬이다
				if (!visited[x][y]) {
					cnt++;
					bfs(x, y);
				}
			}

			System.out.println(cnt);
		}
	}

	static void bfs(int x, int y) {
		Queue<point> q = new ArrayDeque<>();
		q.offer(new point(x, y));
		visited[x][y] = true; // 시작 위치 방문처리

		while (!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.poll().y;

			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				// 맵 크기를 벗어나면
				if (!isValid(nx, ny))
					continue;
				// 이미 방문했거나 막혔다면 다음 탐색
				if (visited[nx][ny] || arr[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				q.offer(new point(nx, ny));
			}
		}
	}

	static boolean isValid(int nx, int ny) {
		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			return false;
		return true;
	}
}
