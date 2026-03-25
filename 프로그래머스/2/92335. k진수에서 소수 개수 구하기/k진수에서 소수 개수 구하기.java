class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String converted = Integer.toString(n, k);
        String[] arr = converted.split("0");
        
        for (String s : arr) {
            if (s.isEmpty()) continue;
            
            long num = Long.parseLong(s);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num < 2) return false;
        
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}