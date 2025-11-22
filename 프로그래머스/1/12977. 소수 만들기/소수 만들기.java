import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        boolean[] prime = new boolean[3001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        for(int i = 2; i * i<3001; i++){
            if(!prime[i]) continue;
            for(int j = i * i; j<3001; j+=i) {
                prime[j] = false;
            }
        }

        for(int i = 0; i<nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(prime[sum]) answer++;
                }
            }
        }

        return answer;
    }
}