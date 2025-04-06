import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[][] arr;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (dfs(i, 0)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static boolean dfs(int x, int y) {
		arr[x][y] = '-';
		
		if(y == m - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (arr[nx][ny] != '.')
				continue;

			if(dfs(nx, ny)) return true;
		}

		return false;
	}
}
