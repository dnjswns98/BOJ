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
			int n = Integer.parseInt(br.readLine());

			int total = (1 << 10) - 1;
			int visited = 0;

			int cnt = 1;
			while (true) {
				int num = n * cnt;
				while (num != 0) { // 각 자리수 뽑기
					int k = num % 10;
					visited |= (1 << k); // 해당 자리수가 등장
					num /= 10;
				}
				if(visited == total) break;
				cnt++;
			}

			sb.append("#").append(test).append(" " + n * cnt + "\n");
		}
		System.out.println(sb);
	}
}