class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int[] scoreCnt = new int[k + 1];
        int cnt = 0;
        for(int i : score){
            scoreCnt[i]++;
            cnt++;
        }

        for(int i = k; i >= 1; i--) {
            answer += (scoreCnt[i] / m) * i * m;
            scoreCnt[i - 1] += scoreCnt[i] % m;
        }
        
        return answer;
    }
}