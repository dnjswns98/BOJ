import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        boolean chk = false;
        for(long i = 1; i * i <= n; i++){
            if(i * i == n) {
                return (i + 1) * (i+1);
            }
        }
        
        return answer;
    }
}