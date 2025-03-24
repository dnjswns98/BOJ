import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int n, d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			int result = 0;
			for (int i = 0; i < n; i++) {
				int k = Integer.parseInt(st.nextToken());

				if (k == 0) cnt++;
				else cnt = 0;

				if (cnt == d) {
					result++;
					cnt = 0;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}