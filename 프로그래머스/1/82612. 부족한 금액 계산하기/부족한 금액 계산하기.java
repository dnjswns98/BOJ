class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long sum = 0;
        for(int i = 0; i<count; i++){
            sum += price * (i + 1);
        }
        if(money - sum < 0)
            answer = sum - money;
        
        return answer;
    }
}