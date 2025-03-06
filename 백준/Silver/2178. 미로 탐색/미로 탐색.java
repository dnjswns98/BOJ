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
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 미로 크기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 미로 입력
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		bfs();
		
		System.out.println(arr[n - 1][m - 1]);
	}

	static void bfs() {
		Queue<point> q = new ArrayDeque<>();
		q.offer(new point(0, 0));
		visited[0][0] = true; // 시작 위치 방문처리

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 맵 크기를 벗어나면
				if(!isValid(nx, ny)) continue;
				// 이미 방문했거나 막혔다면 다음 탐색
				if (visited[nx][ny] || arr[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				q.offer(new point(nx, ny));
				arr[nx][ny] = arr[x][y] + 1;
			}
		}
	}
	
	static boolean isValid(int nx, int ny) {
		if(nx < 0 || nx >= n || ny < 0 || ny >= m)
			return false;
		return true;
	}
}
