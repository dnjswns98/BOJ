class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((int)c >= 97 && (int)c <= 122) {
                if((int)c + n >= 123) {
                    c -= 26;
                }
                c+=n;
            }
            else if((int)c >= 65 && (int)c <= 90) {
                if((int)c + n >= 91) {
                    c -= 26;
                }
                c+=n;
            }
            System.out.println(c);
            answer += String.valueOf(c);
        }
        
        return answer;
    }
}