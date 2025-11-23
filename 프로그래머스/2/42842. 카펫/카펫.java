class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for(int i = 1; i * i <= sum; i++) {
            if(sum % i != 0) continue;
                
            int x = sum / i;
            int max = Math.max(i, x);
            int min = Math.min(i, x);
            
            int cnt = max * 2 + min * 2 - 4;
            if(cnt == brown) {
                answer[0] = max;
                answer[1] = min;
                break;
            }
        }
        
        return answer;
    }
}