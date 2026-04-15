import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int cnt = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : number.toCharArray()) {
            while(!stack.isEmpty() && c > stack.peekLast() && cnt < k){
                stack.pollLast();
                cnt++;
            }
            
            stack.add(c);
        }
        
        while(cnt < k) {
            stack.pollLast();
            cnt++;
        }
        
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()) {
            answer.append(stack.pollFirst());
        }
        
        return answer.toString();
    }
}