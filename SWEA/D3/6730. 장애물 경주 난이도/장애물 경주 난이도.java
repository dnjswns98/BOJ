import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            int up = 0;
            int down = 0;
            for(int i = 1; i<n; i++) {
                if(arr[i - 1] < arr[i] && up < arr[i] - arr[i - 1]) {
                    up = arr[i] - arr[i - 1];
                }
                else if(arr[i - 1] > arr[i] && down < arr[i - 1] - arr[i]) {
                    down = arr[i - 1] - arr[i];
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(up + " " + down);
        }
    }
}