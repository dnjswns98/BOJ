import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, t;
	static int[][] arr, sum;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		int[] air = new int[2]; // 공기청정기의 행
		int idx = 0;
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					air[idx++] = i;
				}
			}
		}

		int time = 0;
		while (time < t) {
			// 미세먼지 확산
			sum = new int[n][m]; // 1초가 지날때마다 확산되는 미세먼지 저장
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] > 0) { // 미세먼지가 있다면
						int cnt = 0; // 확산된 방향의 개수
						int dust = arr[i][j] / 5; // 확산되는 미세먼지 양
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];

							if (nx < 0 || nx >= n || ny < 0 || ny >= m)
								continue;
							if (arr[nx][ny] != -1) {
								sum[nx][ny] += dust;
								cnt++;
							}
						}
						arr[i][j] -= dust * cnt;
					}
				}
			}

			// 변경된 미세먼지
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] += sum[i][j];
				}
			}

			// 위쪽 공기청정기
			int top = air[0];
			for (int i = top - 1; i > 0; i--) arr[i][0] = arr[i - 1][0];
			for (int i = 0; i < arr[0].length - 1; i++) arr[0][i] = arr[0][i + 1];
			for (int i = 0; i < top; i++) arr[i][arr[0].length - 1] = arr[i + 1][arr[0].length - 1];
			for (int i = arr[0].length - 1; i > 1; i--) arr[top][i] = arr[top][i - 1];
			arr[top][1] = 0; // 공기청정기에서 나오는 바람

			// 아래쪽 공기청정기
			int bottom = air[1];
			for (int i = bottom + 1; i < n - 1; i++) arr[i][0] = arr[i + 1][0];
			for (int i = 0; i < m - 1; i++) arr[n - 1][i] = arr[n - 1][i + 1];
			for (int i = n - 1; i > bottom; i--) arr[i][m - 1] = arr[i - 1][m - 1];
			for (int i = m - 1; i > 1; i --) arr[bottom][i] = arr[bottom][i - 1];
			arr[bottom][1] = 0;
			
			time++;
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result += arr[i][j];
			}
		}

		System.out.println(result + 2);
	}
}