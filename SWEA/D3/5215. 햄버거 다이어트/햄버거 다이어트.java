import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

	static int n, l;
	static int[][] arr;
	
	static class Group implements Comparable<Group>{
		int x;
		int y;
		int cost;
		
		public Group(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Solution.Group o) {
			return Integer.compare(o.cost, this.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			arr = new int[n][2];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[l + 1];
			for(int i = 0; i< n; i++) {
				for(int j = l; j >= arr[i][1]; j--) {
					dp[j] = Math.max(dp[j], dp[j - arr[i][1]] + arr[i][0]);
				}
			}
			sb.append("#").append(t).append(" ");
			sb.append(dp[l]).append('\n');
		}
		System.out.println(sb);
	}
}
