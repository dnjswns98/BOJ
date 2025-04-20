import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][n];
			int INF = 1000000000;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && arr[i][j] == 0) {
						arr[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(arr[i][j] > arr[i][k] + arr[k][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<n; i++) {
				int cc = 0;
				for(int j = 0; j<n; j++) {
					cc += arr[i][j];
				}
				min = Math.min(min, cc);
			}

			sb.append("#").append(test).append(" " + min + "\n");
		}
		System.out.println(sb);
	}
}