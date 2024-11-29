import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int max = 0;
            int row_max = 0;
            int col_max = 0;
            int cross_max = 0;
            int[][] arr = new int[100][100];
            for(int i = 0; i<100; i++) {
                int sum = 0;
                for(int j = 0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                    sum += arr[i][j];
                }
                if(sum > row_max) {
                    row_max = sum;
                }
            }

            for(int i = 0; i<100; i++) {
                int sum = 0;
                for(int j = 0; j<100; j++) {
                    sum += arr[j][i];
                }
                if(sum > col_max) {
                    col_max = sum;
                }
            }

            if(row_max > col_max) {
                max = row_max;
            }
            else {
                max = col_max;
            }

            int right_sum = 0;
            for(int i = 0; i<100; i++) {
                right_sum += arr[i][i];
            }

            int left_sum = 0;
            for(int i = 99; i>=0; i--) {
                left_sum += arr[i][99 - i];
            }

            if(right_sum > left_sum) {
                cross_max = right_sum;
            }
            else {
                cross_max = left_sum;
            }

            if(max < cross_max) {
                max = cross_max;
            }

            System.out.print("#" + test_case + " ");
            System.out.println(max);
        }
    }
}
