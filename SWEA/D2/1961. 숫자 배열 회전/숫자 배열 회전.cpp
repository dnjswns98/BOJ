import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] rotation_90 = rotate(arr, n);
            int[][] rotation_180 = rotate(rotation_90, n);
            int[][] rotation_270 = rotate(rotation_180, n);

            System.out.println("#" + test_case + " ");
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    System.out.print(rotation_90[i][j]);
                }
                System.out.print(" ");

                for(int j = 0; j<n; j++) {
                    System.out.print(rotation_180[i][j]);
                }
                System.out.print(" ");

                for(int j = 0; j<n; j++) {
                    System.out.print(rotation_270[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static int[][] rotate(int[][] arr, int size) {
        int[][] result = new int[size][size];
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size; j++) {
                result[i][j] = arr[size - 1 - j][i];
            }
        }
        return result;
    }
}
