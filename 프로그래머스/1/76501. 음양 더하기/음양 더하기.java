class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < signs.length; i++){
            //양의 부호
            if(signs[i]){
                answer += absolutes[i];
            }
            //음의 부호
            else{
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }
}