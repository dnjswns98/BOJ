import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i<progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            dq.add(day);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!dq.isEmpty()) {
            int day = dq.poll();
            int cnt = 1;
            
            while(!dq.isEmpty() && day >= dq.peek()) {
                dq.poll();
                cnt++;
            }
            
            list.add(cnt);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}