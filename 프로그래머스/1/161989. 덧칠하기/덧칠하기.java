class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for(int i = 1; i<section.length; i++){
            if(start + m > section[i]){
                continue;
            }
            start = section[i];
            answer++;
        }
        
        return answer;
    }
}