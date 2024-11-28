import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            int cnt = 0;
            boolean check = false;
            for(int i = 0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c == '1' && !check) {
                    cnt++;
                    check = true;
                }
                else if(c == '0' && check) {
                    cnt++;
                    check = false;
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }
}