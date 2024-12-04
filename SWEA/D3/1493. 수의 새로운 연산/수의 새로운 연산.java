import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int[] point_P = findPoint(p);
            int[] point_Q = findPoint(q);

            int x = point_P[0] + point_Q[0];
            int y = point_P[1] + point_Q[1];

            int sum = 0;
            for(int i = 1; i<x+y-1; i++) {
                sum += i;
            }

            int result = sum + x;

            System.out.print("#" + test_case + " ");
            System.out.println(result);
        }
    }

    static int[] findPoint(int n) {
        int[] num = calculator(n);
        int startNum = num[1] - num[0] + 1;
        int addPoint = n - startNum;
        int[] point = {1 + addPoint, num[0] - addPoint}; //x, y 좌표
        return point;
    }

    static int[] calculator(int n) {
        int startIdx = 0;
        int endNum = 0;
        while(endNum < n) {
            startIdx++;
            endNum += startIdx;
        }
        int[] ans = {startIdx, endNum};
        return ans;
    }
}
