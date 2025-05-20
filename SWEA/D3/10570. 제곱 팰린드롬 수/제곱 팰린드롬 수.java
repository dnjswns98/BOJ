import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i = a; i<=b; i++) {
				int sqrt = (int) Math.sqrt(i);
				if(sqrt * sqrt == i && isPalindrome(sqrt) && isPalindrome(i))
					cnt++;
			}
			
			System.out.println("#" + test + " " + cnt);
		}
	}
	
	static boolean isPalindrome(int num) {
		String s = String.valueOf(num);
		return s.equals(new StringBuilder(s).reverse().toString());
	}
}