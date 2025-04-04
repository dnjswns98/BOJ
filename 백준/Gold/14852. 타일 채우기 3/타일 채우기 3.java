import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 1. 크기 1짜리를 붙이는 방법 (크기 1을 구성할 수 있는 경우의 수는 2개임)
		// dp[n] = dp[n - 1] * 2
		// 2. 크기 2짜리를 붙이는 방법 : 1*2 크기의 블록과 1*1크기의 블록으로 크기 2를 구성하는 경우 4가지
		// 2 - 1. 중복 제거 : 1*1블록으로 2*2를 구성하는 경우 1번 과정과 겹치는 블록 발생.
		// 따라서 dp[n] = dp[n - 2] * 3
		// 3. 특별한 블록 2개
		// n이 3이상부터는 각 n마다 특별한 블록이 2개씩 생성된다.
		// 1번 2번 과정으로 특별한 블록 오른쪽에 붙이는 경우까지 완료.
		// 그러나 특별한 블록 왼쪽에 붙이는 경우를 생각해야함
		// ex) 3크기의 블록에서 생성되는 특별한 블록 2개 * 1크기 블록 개수 = 크기 4인 블록
		// dp[n] = dp[n - 3] * 2 (3에서 생성되는 특별한 블록) + dp[n - 4] * 2 (4에서 생성되는 특별한 블록) + ... dp[1] * 2
		// 즉, 2 * (dp[n - 3] + dp[n - 4] + ... + dp[1]) 이를 누적합으로 구현해야함

		int MOD = 1000000007;
		long[][] dp = new long[2][n + 2]; // n이 1 일때 런타임에러 방지
		dp[1][1] = 2;
		dp[1][2] = 7;
		for (int i = 3; i <= n; i++) {
			dp[0][i] = (dp[0][i - 1] + dp[1][i - 3]) % MOD ;
			dp[1][i] = (dp[1][i - 1] * 2 + dp[1][i - 2] * 3 + 2 * dp[0][i] + 2) % MOD;
		}

		System.out.println(dp[1][n]);
	}
}