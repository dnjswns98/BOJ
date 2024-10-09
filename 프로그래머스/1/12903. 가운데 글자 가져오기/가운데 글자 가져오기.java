class Solution {
    public String solution(String s) {
        String answer = "";
        int num;
        
        if ( s.length() % 2 == 0) {
            num = s.length() / 2 - 1;
            answer += s.charAt(num);
            answer += s.charAt(num+1);
        } else {
            num = s.length() / 2;
            answer += s.charAt(num);
        }
        
        return answer;
    }
}