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
			int m = Integer.parseInt(st.nextToken());
			
			// m을 이진수로 변환했을때, 마지막 n개의 bit가 모두 1인지
			// m을 모두 이진수로 변활할 필요가 없다. 마지막 n개만 알면됨
			// 과연 m을 이진수로 변환해햐할까? 컴퓨터는 어차피 이진수로 저장함
			// 따라서 n개의 bit가 1인 수를 만들고 이것과 m을 & 한다면 된다.
			
			sb.append("#").append(test).append(" ");

			int mask = (1 << n) - 1; // n개의 bit가 1인 수 (111...1)
			// mask:00001111
			// m   :11111111
			// &결과 :00001111
			if((mask & m) == mask) {
				sb.append("ON");
			}
			else {
				sb.append("OFF");
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}