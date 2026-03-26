import java.util.*;

class Solution {
    
    int fullTime = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> chargeMap = new TreeMap<>();
        
        for(String s : records) {
            String[] arr = s.split(" ");
            
            int time = fullTime - timeToMin(arr[0]);
            String car = arr[1];
            String type = arr[2];
            
            chargeMap.merge(car, type.equals("IN") ? time : -time, Integer::sum);
        }
        
        return chargeMap.values()
            .stream()
            .mapToInt(min -> calculator(min, fees))
            .toArray();
    }
    
    public int calculator(int time, int[] fees) {
        if(fees[0] >= time) return fees[1];
        
        return fees[1] + (int) Math.ceil((time - fees[0]) /  (double) fees[2]) * fees[3];
    }
    
    public int timeToMin(String time) {
        String[] parts = time.split(":");
        
        int h = Integer.parseInt(parts[0]) * 60;
        int m = Integer.parseInt(parts[1]);
        
        return h + m;
    }
}