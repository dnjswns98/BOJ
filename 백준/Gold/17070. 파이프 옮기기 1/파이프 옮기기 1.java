import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 0 : 가로, 1 : 세로, 2 : 대각선
		int[][][] dp = new int[n][n][3];
		for(int i = 1; i<n; i++) {
			if(arr[0][i] == 1) break;
			dp[0][i][0] = 1; // 초기값 : 파이프의 오른쪽 끝이면서 방향은 가로
		}

		// 파이프는 우/우하/하 로만 이동이 가능하므로 2열~n열까지만 움직임
		for (int i = 1; i < n; i++) {
			for (int j = 2; j < n; j++) {
				if(arr[i][j] == 1) continue;
				
				// 가로 : 이전이 가로 or 이전이 대각선
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				
				// 세로 : 이전이 세로 or 이전이 대각선
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
						
				// 대각선 : 세 칸이 모두 비어 있어야 가능
				// 모든 방향에서 갈 수 있음
				if(arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]  + dp[i - 1][j - 1][2];
				}
			}
		}

		
		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}
}
