import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
			
            System.out.print("#" + test_case + " ");
            if(L <= X && X <= U) {
                System.out.println(0);
            }
            else if(X < L) {
                System.out.println(L - X);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}