class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int start = total/num - num/2;
        if(total%num != 0){
            start++;
        }
        
        for(int i = 0; i<num; i++){
            answer[i] = start++;
        }
        
        return answer;
    }
}