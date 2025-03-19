import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int n, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);

		System.out.println(result);
	}

	static void dfs(int x, int y, int direction) {
		if (x == n - 1 && y == n - 1) {
			result++;
			return;
		}

		// 가로
		if (direction == 0) {
			// 우측 이동
			if (y + 1 < n && arr[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
		}
		// 세로
		else if (direction == 1) {
			// 하
			if (x + 1 < n && arr[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
		}
		// 대각선
		else if (direction == 2) {
			// 우측 이동
			if (y + 1 < n && arr[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			// 하
			if (x + 1 < n && arr[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
		}

		// 우측 하단은 어떤 방향이던지 갈 수 있음
		if (x + 1 < n && y + 1 < n && arr[x + 1][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}
	}
}
