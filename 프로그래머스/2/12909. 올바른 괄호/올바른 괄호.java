import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(c);
            }
            else {
                if(st.isEmpty()) {
                    return false;
                }
                else st.pop();
            }
        }
        
        if(!st.isEmpty()) return false;

        return true;
    }
}