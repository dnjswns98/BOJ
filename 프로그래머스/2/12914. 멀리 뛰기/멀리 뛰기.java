class Solution {
    public long solution(int n) {
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        cnt[1] = 1;
        for(int i = 2; i<=n; i++){
            cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 1234567;
        }
        
        return cnt[n];
    }
}