import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]); // A의 최대공약수
            gcdB = gcd(gcdB, arrayB[i]); // B의 최대공약수
        }
        
        int answerA = check(gcdA, arrayB);
        int answerB = check(gcdB, arrayA);
        
        return Math.max(answerA, answerB);
    }
    
    public int check(int target, int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % target == 0)
                return 0;
        }
        
        return target;
    }
    
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}