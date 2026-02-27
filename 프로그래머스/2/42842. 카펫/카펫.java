class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 노란색은 최소 1 이므로 격자의 세로는 최소 3부터 시작
        int sum = brown + yellow;
        for(int i = 3; i * i <= sum; i++) {
            int width = sum / i; // 가로
            if(width * i == sum) {
                //  yellow의 개수 = (가로 - 2) * (세로 - 2)
                if((width - 2) * (i - 2) == yellow){
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}