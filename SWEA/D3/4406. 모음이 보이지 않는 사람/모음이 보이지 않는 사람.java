import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            String[] arr = {"a","e","i","o","u"};
            for(String alpha : arr) {
                s = s.replace(alpha, "");
            }

            System.out.print("#" + test_case + " ");
            System.out.println(s);
        }
    }
}