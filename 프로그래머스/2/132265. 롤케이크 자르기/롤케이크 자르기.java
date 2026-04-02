import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        
        for(int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        
        for(int i : topping){
            left.add(i);
            
            if(right.get(i) == 1){
                right.remove(i);
            }
            else {
                right.put(i, right.get(i) - 1);
            }
            
            if(left.size() == right.size()){
                answer++;
            }
        }
        
        return answer;
    }
}