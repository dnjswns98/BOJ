class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            for(char c : s.toCharArray()){
                if(c == '0'){
                    answer[1]++;
                }
            }
            s = s.replace("0", "");
            
            int x = s.length();
            StringBuilder sb = new StringBuilder();
            while(x != 0) {
                sb.append(x % 2);
                x /= 2;
            }
            s = sb.reverse().toString();
            answer[0]++;
        }
        
        return answer;
    }
}