import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test <= t; test++) {
			int num = Integer.parseInt(br.readLine());
			
			int bitMask = 0;
			int cnt = 0;
			while(num > 0) {
				int digit = num % 10; // 마지막 자리 수
				if((bitMask & (1 << digit)) == 0) { //처음 발견한 수
					cnt++;
					bitMask |= (1 << digit);
				}
				num /= 10;
			}
			System.out.println("#" + test + " " + cnt);
		}
	}
}