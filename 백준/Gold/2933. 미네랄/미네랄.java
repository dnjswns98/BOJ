import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int r, c, n;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// 맵 입력
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		// 막대기 입력
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int h = r - Integer.parseInt(st.nextToken()); // 막대기 던질 높이
			// 왼쪽에서 던져야함
			if (i % 2 == 0) {
				for (int j = 0; j < c; j++) {
					if (arr[h][j] == 'x') { // 미네랄을 찾았으면
						arr[h][j] = '.';
						break;
					}
				}
			}
			// 오른쪽에서 던져야함
			else {
				for (int j = c - 1; j >= 0; j--) {
					if (arr[h][j] == 'x') { // 미네랄을 찾았으면
						arr[h][j] = '.';
						break;
					}
				}
			}

			// 떠있는 클러스터 찾기위해 바닥과 붙어있는 클러스터 방문
			visited = new boolean[r][c];
			for (int j = 0; j < c; j++) {
				if (arr[r - 1][j] == 'x')
					dfs(r - 1, j);
			}

			// 떠있는 클러스터 찾기
			ArrayList<Point> cluster = new ArrayList<>();
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (arr[j][k] == 'x' && !visited[j][k]) { // 미네랄이지만 방문하지 않았다면 떠있는 것
						cluster.add(new Point(j, k));
						arr[j][k] = '.';
					}
				}
			}

			// 얼만큼 중력을 작용해야하는지 검사 (클러스터 통째로 이동해야하니 클러스터가 이동할 수 있는 최소값을 이동해야함)
			int min = Integer.MAX_VALUE;
			for (Point p : cluster) {
				int height = 0;
				for (int j = p.x + 1; j < r; j++) {
					if(arr[j][p.y] == 'x') break;
					height++;
				}
				min = Math.min(min, height);
			}
			
			// 중력 적용
			for (Point p : cluster) {
				arr[p.x + min][p.y] = 'x';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<r; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= r || ny < 0 || ny >= c)
				continue;
			if (visited[nx][ny] || arr[nx][ny] == '.')
				continue;

			dfs(nx, ny);
		}
	}
}
