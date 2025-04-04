import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
//	    1) 이전에 만들어진 짝수번째 타일의 개수 X 3
//	    2) 그 전전의 전체 타일 개수 X 이전타일의 특별한 타일 개수
//	    3) 해당 위치에서 만들어지는 특별한 타일 개수

		// n이 홀수라면 타일을 채울 수 없다.
		// n크기의 타일은 n-2크기의 타일에서 크기2의 타일을 붙이면된다.
		// 즉, dp[n] = dp[n-2] * dp[2] 이다.
		// 또한, n이 4이상인 경우 각 크기에 맞게 조합으로 나오지 않는 고유한 타일 2가지가 존재한다.
		// 즉, dp[n] = dp[n-2] * dp[2] + 2 이다.
		// n이 6이상인 경우 위와 같은 고유한 타일 2개를 고려해줘야한다.
		// n-2크기인 고유한 타일 2개의 뒤에 크기2짜리가 붙은 경우는 dp[n-2] * dp[2]으로 계산이 된다.
		// 하지만 n-2크기인 고유한 타일2개의 앞에 크기 2짜리가 붙는 경우는 계산하지 않았다.
		// 즉, dp[6] = (dp[4] * dp[2]) + (2) + (dp[2] * 2 = (n이 4인 고유한 타일 2개를 뜻함))
		// dp[8] = (dp[6] * dp[2]) + 2 + (dp[2] * 2 = (n이 6인 고유한 타일 2개)) + (dp[4] * 2 = (n이 4인 고유한 타일 2개))
		// 즉, dp[n] = (dp[n-2] * dp[2]) + (2) + (dp[2] * 2 + dp[4] * 2 + ... + dp[n - 4]* 2)
		
		int[] dp = new int[n + 1];
		if(n == 1) {
			System.out.println(0);
			return;
		}
		dp[2] = 3;
		for (int i = 4; i <= n; i += 2) {
			dp[i] = dp[i - 2] * 3; // 이전에 만들어진 짝수번째 타일의 개수 X 3
			for (int j = i - 4; j >= 0; j -= 2) { // 그 전전의 전체 타일 개수 X 이전타일의 특별한 타일 개수
				dp[i] += dp[j] * 2;
			}
			dp[i] += 2; // 해당 크기의 특별한 타일
		}


		System.out.println(dp[n]);
	}
}