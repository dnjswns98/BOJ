import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int size = triangle.length;

        int[][] dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j];
            }
        }

        for (int i = 1; i < size; i++) {
            dp[i][0] += dp[i - 1][0]; // 왼쪽
            
            for (int j = 1; j <= i; j++) {
                // 왼쪽 위 or 오른쪽 위 중 더 큰 값 선택
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        // 최댓값 반환
        return Arrays.stream(dp[size - 1]).max().getAsInt();
    }
}