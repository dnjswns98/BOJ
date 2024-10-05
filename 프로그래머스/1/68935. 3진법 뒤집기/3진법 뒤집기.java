class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String three = toThree(n); //3진법으로 변환
        
        answer = Integer.parseInt(three, 3);
        
        return answer;
    }
    
    public String toThree(int n){
        String result = "";
        for(int i = n; i>0; i/=3){
            result += String.valueOf(i%3);
        }
        return result;
    }
}