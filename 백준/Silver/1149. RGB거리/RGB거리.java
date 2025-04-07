import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][3];
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
			
			// 현재 집의 색과 이전 집의 색이 같으면 안됨
			// 이전 집의 색 중에 작은 값을 선택
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		int min = Math.min(dp[n][0], dp[n][1]);
		min = Math.min(dp[n][2], min);
		System.out.println(min);
	}
}