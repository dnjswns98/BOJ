import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        answer[numbers.length - 1] = -1;
        stack.offer(numbers[numbers.length - 1]);
        
        for(int i = numbers.length - 2; i>=0; i--) {
            while(!stack.isEmpty() && stack.peekLast() <= numbers[i]) {
                stack.pollLast();
            }
            
            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.offer(numbers[i]);
        }
        
        return answer;
    }
}