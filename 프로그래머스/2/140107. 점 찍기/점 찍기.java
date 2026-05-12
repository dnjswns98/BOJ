import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        if(k > d) return 1;
        
        for(long i = 0; i <= d; i += k) {
            double maxY = Math.sqrt((long)d * d - i * i);
            
            answer += (long)(maxY / k) + 1;
        }
        
        return answer;
    }
}