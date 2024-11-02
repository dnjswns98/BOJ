class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            while(count < index) {
                c += 1;
                if(c > 122) {
                    c -= 26;
                }
                if(!skip.contains(String.valueOf(c))) {
                    count++;
                }
            }
            answer += c;
        }
        
        return answer;
    }
}