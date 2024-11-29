import java.util.*;

public class Solution {
    static int[] chess;
    static int cnt = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            chess = new int[n];
			cnt = 0;
            dfs(0);

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }

    static void dfs(int row) {
        if(row == n) {
            cnt++;
            return;
        }

        for(int col = 0; col < n; col++) {
            chess[row] = col;
            if(isSafe(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isSafe(int row) {
        for(int i = 0; i<row; i++) {
            if (chess[row] == chess[i] || row - i == Math.abs(chess[row] - chess[i])) {
                return false;
            }
        }
        return true;
    }
}
