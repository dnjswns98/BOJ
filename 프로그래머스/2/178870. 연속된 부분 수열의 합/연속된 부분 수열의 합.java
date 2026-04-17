class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0, right = 0;
        int sum = sequence[0];
        int cnt = Integer.MAX_VALUE;
        while(left < sequence.length && right < sequence.length) {
            if(sum == k) {
                if(cnt > right - left + 1) {
                    cnt = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            }
            else if(sum < k) {
                right++;
                if(right < sequence.length)
                    sum += sequence[right];
            }
            else {
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}