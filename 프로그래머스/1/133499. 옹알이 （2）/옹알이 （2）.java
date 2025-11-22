class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] word = {"aya", "ye", "woo", "ma"};
        for(String s : babbling) {
            for(String w : word) {
                if(s.contains(w + w)){
                    s = "x";
                }
            }
            if(s.equals("x")) continue;
            
            s = s.replaceAll("aya|ye|woo|ma", "");
            if(s.isEmpty()) answer++;
        }
        
        return answer;
    }
}