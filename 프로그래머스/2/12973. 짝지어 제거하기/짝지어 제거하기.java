import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty()) {
                if(st.peek() == c) st.pop();
                else st.push(c);
            }
            else {
                st.push(c);
            }
        }
        
        if(st.isEmpty()) answer = 1;

        return answer;
    }
}