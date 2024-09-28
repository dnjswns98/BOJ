class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        for(int i = 0; i<s; i++){
            char c = my_string.charAt(i);
            answer += c;
        }
        int j = 0;
        for(int i = 0; i < overwrite_string.length(); i++){
            answer += overwrite_string.charAt(i);
            j++;
        }
        for(int i = s+j; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            answer += c;
        }
        return answer;
    }
}