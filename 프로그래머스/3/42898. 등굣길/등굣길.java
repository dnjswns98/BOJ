class Solution {
    
    static final int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1; // 시작점
        
        // 웅덩이 표시
        for(int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                
                // 시작점은 건너뜀
                if(i == 1 && j == 1) continue;
                
                // 웅덩이
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;   
            }
        }
        
        return dp[n][m];
    }
}