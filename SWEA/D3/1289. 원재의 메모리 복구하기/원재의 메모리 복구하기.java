import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            char c = s.charAt(0);
            int cnt = 0;
            if(c == '1') cnt++;
            for(int i = 1; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(ch != c){
                    cnt++;
                    c = ch;
                }
            }
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}