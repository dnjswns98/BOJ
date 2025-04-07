import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int min;
	static int[] cost, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			cost = new int[4];
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken()); // 이용권 가격
			}

			st = new StringTokenizer(br.readLine());
			dp = new int[13]; // i월까지 이용했을 경우의 최소 비용
			for (int i = 1; i <= 12; i++) {
				int cnt = Integer.parseInt(st.nextToken()); // 이용 계획
				dp[i] = Math.min(dp[i - 1] + cnt * cost[0], dp[i - 1] + cost[1]); // 하루 이용권, 한 달 이용권 비교
				
				if(i >= 3) {
					dp[i] = Math.min(dp[i - 3] + cost[2], dp[i]); // 3달 이용권
				}
			}

			sb.append("#").append(t).append(" ").append(Math.min(dp[12], cost[3])).append("\n");
		}
		System.out.println(sb);
	}
}