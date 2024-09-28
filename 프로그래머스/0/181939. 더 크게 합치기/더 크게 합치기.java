class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String s1 = Integer.toString(a);
        String s2 = String.valueOf(b);
        
        String ab = s1 + s2;
        String ba = s2 + s1;
        
        int c = Integer.valueOf(ab);
        int d = Integer.valueOf(ba);
        
        if(c > d){
            answer = c;
        }
        else{
            answer = d;
        }
        
        return answer;
    }
}