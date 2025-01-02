import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    int sum = arr[i][j];
                    for(int h = 1; h<m; h++) {
                        if(j + h < n) {
                            sum += arr[i][j + h];
                        }
                        if(j - h >= 0) {
                            sum += arr[i][j - h];
                        }
                        if(i + h < n) {
                            sum += arr[i + h][j];
                        }
                        if(i - h >= 0) {
                            sum += arr[i - h][j];
                        }
                    }
                    if(sum > max)
                        max = sum;
                }
            }

            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    int sum = arr[i][j];
                    for(int h = 1; h<m; h++) {
                        if(j + h < n && i + h < n) {
                            sum += arr[i + h][j + h];
                        }
                        if(j - h >= 0 && i - h >= 0) {
                            sum += arr[i - h][j - h];
                        }
                        if(i + h < n && j - h >= 0) {
                            sum += arr[i + h][j - h];
                        }
                        if(i - h >= 0 && j + h < n) {
                            sum += arr[i - h][j + h];
                        }
                    }
                    if(sum > max)
                        max = sum;
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(max);
        }
    }
}