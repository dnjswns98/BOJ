import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        //내림차순으로 정렬
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        
        int exp = s.length;
        for(int i = 0; i<s.length; i++){
            answer += Long.valueOf(s[i]) * Math.pow(10,exp-1);
            exp--;
        }

        return answer;
    }
}