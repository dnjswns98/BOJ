import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int cnt = 0;
            String find = sc.next();
            String s = sc.next();
            while(s.contains(find)) {
                cnt++;
                s = s.substring(s.indexOf(find) + find.length());
            }

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }
}
