class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] num = new int[number + 1];
        for(int i = 1; i<=number; i++){
            for(int j = i; j <= number; j+=i) {
                num[j]++;
            }
        }
        
        for(int i = 1; i<=number; i++){
            if(num[i] > limit)
                num[i] = power;
            
            answer += num[i];
        }
        
        return answer;
    }
}