import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			long n = Long.parseLong(br.readLine());
			
			int cnt = 0;
			while(n != 2) {
				long temp = (long) Math.sqrt(n);
				if(temp * temp == n) { //n의 제곱근이 정수인 경우
					n = temp;
				}
				else { // n의 제곱근이 정수가 아니라면
					//n값에서 +1씩 계속 해주면서 제곱근이 정수가 되는 값을 찾아야한다.
					temp++;
					cnt += temp*temp - n; // 제곱근이 정수가 되는 값 - n = +1을 해야하는 횟수
					n = temp;
				}
				cnt++;
			}
			
			System.out.println("#" + test + " " + cnt);
		}
	}
}
