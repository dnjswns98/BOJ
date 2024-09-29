class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"ma","ye","woo","aya"};
        
        for(String b_str : babbling){
            for(String w_str : word){
                b_str = b_str.replace(w_str," ");
            }
            b_str = b_str.trim();
            if(b_str.length() == 0)
                answer++;
        }
        
        return answer;
    }
}