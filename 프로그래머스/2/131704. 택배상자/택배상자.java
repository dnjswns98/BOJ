import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i <= order.length; i++) {
            dq.add(i);
            
            while(!dq.isEmpty() && dq.peekLast() == order[answer]) {
                dq.pollLast();
                answer++;
            }
        }
        
        return answer;
    }
}