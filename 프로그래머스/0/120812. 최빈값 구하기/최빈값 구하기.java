import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        
        for(int n : array){
            h.put(n, h.getOrDefault(n, 0) + 1);
        }
        
        int maxCnt = 0;
        int maxNum = 0;
        for(Map.Entry<Integer, Integer> entry : h.entrySet()){
            if(entry.getValue() > maxCnt){
                maxCnt = entry.getValue();
                maxNum = entry.getKey();
            }
            else if(entry.getValue() == maxCnt){
                maxNum = -1;
            }
        }
        
        return maxNum;
    }
}