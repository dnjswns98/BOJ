import java.util.Arrays;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] cnt = new int[201];
        
        for(int[] arr : lines){
            int left = arr[0] + 100;
            int right = arr[1] + 100;
            
            for(int i = left; i<right; i++){
                cnt[i]++;
            }
        }
        
        for(int i : cnt){
            if(i > 1) answer++;
        }
        
        return answer;
    }
}