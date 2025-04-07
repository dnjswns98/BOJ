import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	static int n, k, maxCnt;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, arr[i][j]);
				}
			}

			// 가장 높은 봉우리 찾아서 위치 저장
			ArrayList<Point> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == max) {
						list.add(new Point(i, j));
					}
				}
			}

			maxCnt = 0;
			visited = new boolean[n][n];
			for (Point p : list) { // 가장 높은 봉우리에서 탐색 시작
				dfs(p.x, p.y, 1, false);
			}
			
			sb.append("#").append(t).append(" " + maxCnt);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y, int cnt, boolean check) {
		maxCnt = Math.max(maxCnt, cnt);
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if (visited[nx][ny]) continue;

			if (arr[nx][ny] < arr[x][y]) { // 자신보다 낮다면
				dfs(nx, ny, cnt + 1, check);
			} 
			else { // 같거나 크다면 깎아야 한다.
				if (!check) { // 아직 기회가 남아있다면
					for (int j = 1; j <= k; j++) {
						if (arr[nx][ny] - j < arr[x][y]) {
							arr[nx][ny] -= j;
							dfs(nx, ny, cnt + 1, true);
							arr[nx][ny] += j;
						}
					}
				}
			}
		}
		
		visited[x][y] = false;
	}
}