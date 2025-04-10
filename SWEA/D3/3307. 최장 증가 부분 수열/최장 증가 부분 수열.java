import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(max, dp[i]);
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}