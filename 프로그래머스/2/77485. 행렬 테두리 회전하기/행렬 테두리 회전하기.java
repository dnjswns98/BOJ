class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows + 1][columns + 1];
        int num = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                arr[i][j] = num++;
            }
        }
        
        int idx = 0;
        for(int[] query : queries) {
            int x1 = query[0], y1 = query[1];
            int x2 = query[2], y2 = query[3];
            
            int prev = arr[x1][y1];
            int min = arr[x1][y1];
            
            // 위쪽(->)
            for(int j = y1 + 1; j <= y2; j++) {
                int temp = arr[x1][j];
                arr[x1][j] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            
            // 오른쪽(아래방향)
            for(int i = x1 + 1; i <= x2; i++) {
                int temp = arr[i][y2];
                arr[i][y2] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            
            // 아래쪽(<-)
            for(int j = y2 - 1; j >= y1; j--) {
                int temp = arr[x2][j];
                arr[x2][j] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            
            // 왼쪽(위쪽방향)
            for(int i = x2 - 1; i >= x1; i--) {
                int temp = arr[i][y1];
                arr[i][y1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            
            answer[idx++] = min;
        }
        
        return answer;
    }
}