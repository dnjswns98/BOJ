class Solution {
    
    int zeroCnt = 0;
    int oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        dfs(0, 0, arr.length, arr);
        
        return new int[] {zeroCnt, oneCnt};
    }
    
    public void dfs(int x, int y, int size, int[][] arr) {
        boolean isDifference = false;
        int init = arr[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(init != arr[i][j]) {
                    isDifference = true;
                    break;
                }
            }
            if(isDifference) break;
        }
        
        // 다른 값이라면
        if(isDifference) {
            dfs(x, y, size/2, arr); // 좌측상단
            dfs(x, y + size/2, size/2, arr); // 우측상단
            dfs(x + size/2, y, size/2, arr); // 좌측하단
            dfs(x + size/2, y + size/2, size/2, arr); // 우측하단
        }
        else {
            if(init == 0) zeroCnt++;
            else oneCnt++;
        }
    }
}