class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    public void dfs(int idx, int sum, int target , int[] numbers) {
        if(idx == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(idx + 1, sum + numbers[idx], target, numbers);
        dfs(idx + 1, sum - numbers[idx], target, numbers);
    }
}