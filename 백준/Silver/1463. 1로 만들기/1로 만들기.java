import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 3];
		dp[2] = 1;
		dp[3] = 1;
		for(int i = 2; i<=n; i++) {
			if(i % 2 == 0 && i % 3 == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i / 3]) + 1;
			}
			else if(i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			}
			else if(i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			}
			else dp[i] = dp[i - 1] + 1;
		}
		
		System.out.println(dp[n]);
	}
}
