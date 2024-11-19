import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        for(String str : cities) {
            String city = str.toUpperCase();
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
            }
            else {
                answer += 5;
                cache.add(city);
            }
            
            if(cache.size() > cacheSize) {
                cache.remove(0);
            }
        }
        
        return answer;
    }
}