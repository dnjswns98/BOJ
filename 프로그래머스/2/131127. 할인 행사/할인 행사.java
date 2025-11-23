import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wanted = new HashMap<>();
        for(int i = 0; i<want.length; i++) {
            wanted.put(want[i], number[i]);
        }
        
        for(int i = 0; i<10; i++) {
            if(wanted.containsKey(discount[i])) {
                wanted.put(discount[i], wanted.get(discount[i]) - 1);
            }
        }
        
        if(isPossible(wanted)) answer++;
        
        for(int i = 10; i < discount.length; i++) {
            if(wanted.containsKey(discount[i - 10])) {
                wanted.put(discount[i - 10], wanted.get(discount[i - 10]) + 1);
            }
            
            if(wanted.containsKey(discount[i])) {
                wanted.put(discount[i], wanted.get(discount[i]) - 1);
            }
            
            if(isPossible(wanted)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPossible(HashMap<String, Integer> wanted) {
        for(String key : wanted.keySet()) {
            if(wanted.get(key) != 0) return false;
        }
        return true;
    }
}