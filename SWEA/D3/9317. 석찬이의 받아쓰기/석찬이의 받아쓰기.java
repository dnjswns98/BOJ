import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            int cnt = 0;
            for(int i = 0; i<n; i++) {
                if(a.charAt(i) == b.charAt(i)) {
                    cnt++;
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }
}