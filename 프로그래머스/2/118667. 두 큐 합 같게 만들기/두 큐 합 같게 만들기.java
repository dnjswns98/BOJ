import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0;
        for(int i = 0 ; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        
        int limit = queue1.length * 3;
        boolean check = false;
        while(answer <= limit) {
            if(sum1 == sum2) {
                check = true;
                break;
            }
            else if(sum1 < sum2) {
                int n = q2.poll();
                sum1 += n;
                sum2 -= n;
                q1.add(n);
            }
            else {
                int n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.add(n);
            }
            answer++;
        }
        
        return check ? answer : -1;
    }
}