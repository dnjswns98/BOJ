class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int size = board.length;
        for(int i = 0; i<4; i++){
            int nx = dx[i] + h;
            int ny = dy[i] + w;
            if(nx < size && ny < size && nx >= 0 && ny >= 0 && board[h][w].equals(board[nx][ny])){
                answer++;
            }
        }
        
        return answer;
    }
}