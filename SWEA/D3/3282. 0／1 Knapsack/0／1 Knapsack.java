import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][2];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[k + 1];
			for(int i = 0; i<n; i++) {
				for(int j = k; j>=arr[i][0]; j--) {
					dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
				}
			}

			sb.append("#").append(t).append(" ").append(dp[k]).append("\n");
		}
		System.out.println(sb);
	}
}