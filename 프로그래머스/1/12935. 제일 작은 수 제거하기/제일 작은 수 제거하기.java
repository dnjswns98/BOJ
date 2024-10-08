class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        
        //리턴하려는 배열이 빈 배열
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        //최소값 찾기
        for(int i = 0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                idx = i;
            }
        }
        
        int[] answer = new int[arr.length - 1];
        int j = 0;
        for(int i = 0; i<arr.length; i++){
            if(idx == i) 
                continue;
            
            answer[j++] = arr[i];
        }
        
        return answer;
    }
}