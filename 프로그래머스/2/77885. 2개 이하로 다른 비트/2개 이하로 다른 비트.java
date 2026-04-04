class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i<numbers.length; i++) {
            if(numbers[i] % 2 == 0) { // 짝수라면 끝에 +1만 하면 된다.
                answer[i] = numbers[i] + 1;
                continue;
            }
            
            // 홀수라면 가장 오른쪽 0을 1로 바꾸고, 그 오른쪽 비트를 0으로 바꾼다.
            String s = Long.toString(numbers[i], 2);
            StringBuilder sb = new StringBuilder();
            
            // 만약 모든 bit가 1이라면
            if(!s.contains("0")) {
                sb.append("10").append(s.substring(1));
            }
            else {
                int lastZero = s.lastIndexOf("0");
                
                sb.append(s.substring(0, lastZero));
                sb.append("10");
                sb.append(s.substring(lastZero + 2));
            }
            
            answer[i] = Long.parseLong(sb.toString(), 2);
        }
        
        return answer;
    }
}