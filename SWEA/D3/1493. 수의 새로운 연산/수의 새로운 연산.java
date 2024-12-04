import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int[] loop = calculator(p);
            int start = loop[1] - loop[0] + 1;
            int pX = 1 + p-start;
            int pY = loop[0] - (p - start);

            loop = calculator(q);
            start = loop[1] - loop[0] + 1;
            int qX = 1 + q-start;
            int qY = loop[0] - (q - start);

            int x = pX + qX;
            int y = pY + qY;

            int sum = 0;
            for(int i = 1; i<x+y-1; i++) {
                sum += i;
            }
            
            int result = sum + x;

            System.out.print("#" + test_case + " ");
            System.out.println(result);
        }
    }

    static int[] calculator(int n) {
        int start = 0;
        int end = 0;
        while(end < n) {
            start++;
            end += start;
        }
        int[] ans = new int[2];
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
}
