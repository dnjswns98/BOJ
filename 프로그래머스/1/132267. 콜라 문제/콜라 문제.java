class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int bottle = n;
        while(true) {
            int rest = bottle % a;
            int div = bottle / a;
            
            if(div >= 1) {
                bottle = div * b + rest;
                answer += div * b;
            }
            else break;
        }
        
        return answer;
    }
}