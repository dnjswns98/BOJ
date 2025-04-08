import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][][] dp = new long[n][n][3];
		for(int i = 1; i<n; i++) {
			if(arr[0][i] == 1) break; // 벽 마주치면 끝
			dp[0][i][0] = 1; // 초기화
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = 2; j<n; j++) {
				if(arr[i][j] == 1) continue;
				
				// 가로 : 이전이 가로 or 대각선
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				
				// 세로 : 이전이 세로 or 대각선
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				
				// 대각선 : 모든 방향 가능
				// 인접칸 빈 칸 체크
				if(arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);
	}
}