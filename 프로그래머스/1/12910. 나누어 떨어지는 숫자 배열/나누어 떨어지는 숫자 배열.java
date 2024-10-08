import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(i % divisor == 0){
                list.add(i);
            }
        }       
        
        if(list.size() == 0){
            int[] answer = {-1};
            return answer;
        }
        
        Collections.sort(list);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}