class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int cnt = 1;
        int i = 0;
        int j = 0;
        int d_idx = 0;
        
        while(cnt<=n*n){
            answer[i][j] = cnt++;
            
            int nx = i + dx[d_idx % 4];
            int ny = j + dy[d_idx % 4];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || answer[nx][ny] != 0){
                d_idx++;
            }
            
            i += dx[d_idx % 4];
            j += dy[d_idx % 4];
        }
        
        return answer;
    }
}