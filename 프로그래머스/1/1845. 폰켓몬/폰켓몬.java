class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        boolean[] choice = new boolean[200001];
        for(int a : nums){
            if(choice[a]) continue;
            
            choice[a] = true;
            answer++;
        }
        
        if(nums.length / 2 < answer){
            answer = nums.length / 2;
        }
        
        return answer;
    }
}