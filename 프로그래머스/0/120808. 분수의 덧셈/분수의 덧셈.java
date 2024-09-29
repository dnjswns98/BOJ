class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int gcd = getGCD(denom1, denom2); //최대공약수
        int lcm = denom1 * denom2 / gcd; //최소공배수 and 분모
        numer1 = numer1 * lcm/denom1; //최소공배수인 분모에 맞춰서 분자 구하기
        numer2 = numer2 * lcm/denom2;
        int numer = numer1 + numer2; //분자 합

        gcd = getGCD(numer,lcm); //분자와 분모의 최대공약수
        
        answer[0] = numer / gcd;
        answer[1] = lcm / gcd;
        
        return answer;
    }
    
    public int getGCD(int a, int b){
        if(a%b == 0){
            return b;
        }
        return getGCD(b, a%b);
    }
}