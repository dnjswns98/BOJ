import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] num = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String n : num){
            int x = Integer.parseInt(n);
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        
        answer += min + " " + max;
        
        return answer;
    }
}