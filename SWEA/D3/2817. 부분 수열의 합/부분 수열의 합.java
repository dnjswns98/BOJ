import java.util.*;

public class Solution {
    static int k;
    static int n;
    static int result;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            k = sc.nextInt();
            result = 0;
            arr = new int[n];

            for(int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
            }

            dfs(0, 0);

            System.out.print("#" + test_case + " ");
            System.out.println(result);
        }
    }

    static void dfs(int sum, int i) {
        if(sum == k) {
            result++;
            return;
        }
        else if(sum > k || i == n) {
            return;
        }

        dfs(sum + arr[i], i+1);
        dfs(sum,i+1);
    }
}
