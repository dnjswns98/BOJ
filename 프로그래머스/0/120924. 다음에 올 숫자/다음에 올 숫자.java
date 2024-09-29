class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int d = common[1] - common[0];
        if(common[1] + d == common[2]){
            answer = common[common.length - 1] + d;
        }
        else{
            d = common[1] / common[0];
            answer = common[common.length - 1] * d;
        }
        
        return answer;
    }
}