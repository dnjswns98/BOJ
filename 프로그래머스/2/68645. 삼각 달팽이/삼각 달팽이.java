class Solution {
    
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        
        int[][] map = new int[n][n];
        
        int x = -1, y = 0; // 시작 위치
        int num = 1;
        for(int i = 0; i<n; i++) { // 총 n번 방향 전환
            for(int j = i; j < n; j++) { // 한 방향당 진행하는 수
                
                // 하단, 우측, 상단 순서로 반복됨
                if(i % 3 == 0) {
                    x++;
                }
                else if(i % 3 == 1) {
                    y++;
                }
                else {
                    x--;
                    y--;
                }
                
                map[x][y] = num++;
            }
        }

        int idx = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}