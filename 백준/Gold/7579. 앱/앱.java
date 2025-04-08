import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, min;
	static int[] mem, cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		mem = new int[n];
		for(int i = 0; i<n; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		cost = new int[n];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}
		
		// 금액에 따라 가능한 최대 메모리 확보를 저장
		int[] dp = new int[sum + 1];
		for(int i = 0; i<n; i++) {
			for(int j = sum; j>=cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + mem[i]);
			}
		}


		for(int i = 0; i<=sum; i++) {
			if(dp[i] >= m) {
				System.out.println(i);
				return;
			}
		}
	}
	
	static void dfs(int idx, int sum1, int sum2) {
		if(sum1 >= m) {
			min = Math.min(min, sum2);
			return;
		}
		
		if(idx >= n) return;
		
		dfs(idx + 1, sum1 + mem[idx], sum2 + cost[idx]);
		dfs(idx + 1, sum1, sum2);
	}
}