import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
       
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        for(int i = 0; i<answers.length; i++) {
            if(answers[i] == a[i % 5]) {
                cntA++;
            }
            if(answers[i] == b[i % 8]) {
                cntB++;
            }
            if(answers[i] == c[i % 10]) {
                cntC++;
            }
        }
        
        int max = Math.max(cntA, Math.max(cntB, cntC));
        
        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        if(max == cntA) answer.add(1);
        if(max == cntB) answer.add(2);
        if(max == cntC) answer.add(3);
        
        return answer;
    }
}