import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.length() % 2 == 1) return 0;
        
        for(int i = 0; i<s.length(); i++) {
            Stack<Character> st = new Stack<>();
            boolean isPossible = true;
            for(int j = 0; j<s.length(); j++){
                int idx = (i + j) % s.length();
                
                if(s.charAt(idx) == '(' || s.charAt(idx) == '[' || s.charAt(idx) == '{')
                    st.push(s.charAt(idx));
                else if(st.isEmpty()) {
                    if(s.charAt(idx) == ')' || s.charAt(idx) == '}' || s.charAt(idx) == ']') {
                        isPossible = false;
                        break;
                    }
                }
                else {
                    if(st.peek() == '(' && s.charAt(idx) == ')')
                        st.pop();
                    else if(st.peek() == '{' && s.charAt(idx) == '}')
                        st.pop();
                    else if(st.peek() == '[' && s.charAt(idx) == ']')
                        st.pop();
                    else {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if(isPossible) answer++;
        }
        
        return answer;
    }
}