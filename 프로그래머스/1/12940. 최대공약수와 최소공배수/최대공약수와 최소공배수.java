class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = GCD(n,m);
        answer[1] = n*m/answer[0];
        
        return answer;
    }
    
    public int GCD(int n, int m){
        if(n%m == 0)
            return m;
        return GCD(m,n%m);
    }
}