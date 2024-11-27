import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int average = 0;
            for(int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
                average += arr[i];
            }
            average /= n;

            int cnt = 0;
            for(int num : arr) {
                if(num <= average)
                    cnt++;
            }

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }
}