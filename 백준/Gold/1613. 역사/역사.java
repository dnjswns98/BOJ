import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		boolean[][] dp = new boolean[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[a][b] = true;
		}

		for(int t = 1; t<=n; t++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1 ; j<=n; j++) {
					if(dp[i][t] && dp[t][j]) {
						dp[i][j] = true;
					}
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(dp[a][b]) {
				sb.append(-1);
			}
			else {
				if(dp[b][a]) sb.append(1);
				else sb.append(0);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}