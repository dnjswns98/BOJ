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
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][n];
		int max = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				dp[i][j] = 1;
				for(int k = 0; k<=i; k++) {
					for(int h = 0; h<=j; h++) {
						if(arr[k][h] < arr[i][j] && dp[i][j] < dp[k][h] + 1) {
							dp[i][j] = dp[k][h] + 1;
						}
					}
				}
				max = Math.max(dp[i][j], max);
			}
		}

		System.out.println(max);
	}

}