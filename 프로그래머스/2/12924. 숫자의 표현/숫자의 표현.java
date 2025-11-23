class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int left = 1;
        int right = 1;
        int sum = 0;
        
        while(n >= right) {
            if(sum == n) answer++;

            if(sum >= n) sum -= left++;

            else if(sum < n) sum += right++;
        }
        
        return answer;
    }
}