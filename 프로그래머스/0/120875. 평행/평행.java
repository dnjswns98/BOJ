class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        double[][] line = new double[4][4];
        
        // i와 j번 점 사이의 기울기를 계산하여 line[i][j]에 저장
        for(int i =0; i<4; i++){
            for(int j = i+1; j<4; j++){
                // x 좌표가 같으면 분모가 0가 되므로 Double.MAX_VALUE 사용
                if (dots[i][0] == dots[j][0]) {
                    line[i][j] = Double.MAX_VALUE;
                } else {
                    line[i][j] = (double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
                }
            }
        }
        
        
        if (line[0][1] == line[2][3]) {
            answer = 1;
        }
        if (line[0][2] == line[1][3]) {
            answer = 1;
        }
        if (line[0][3] == line[1][2]) {
            answer = 1;
        }
        return answer;
    }
}