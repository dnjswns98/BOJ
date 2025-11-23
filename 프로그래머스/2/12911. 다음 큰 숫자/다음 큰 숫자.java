class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        for(char c : s.toCharArray()){
            if(c == '1') answer++;
        }
        
        int next = n + 1;
        while(true) {
            int cnt = 0;
            String temp = Integer.toBinaryString(next);
            
            for(char c : temp.toCharArray()){
                if(c == '1') cnt++;
            }
            
            if(answer == cnt) {
                return next;
            }
            next++;
        }
    }
}