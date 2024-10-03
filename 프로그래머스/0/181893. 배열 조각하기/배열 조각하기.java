class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        int right = 100000;
        int left = 0;
        
        for(int i = 0; i<query.length; i++){
            int idx = query[i];
            if(i % 2 == 0){
               right = left + idx;
            }
            else{
                left += idx;
            }
        }
        answer = new int[right - left + 1];
        int idx = 0;
        for(int i = left; i<= right; i++){
            answer[idx++] = arr[i];
        }

        
        return answer;
    }
}