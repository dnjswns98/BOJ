import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> key = new ArrayList<>(map.keySet());
        Collections.sort(key, new Comparator<Integer>(){
           public int compare(Integer o1, Integer o2) {
               return map.get(o2) - map.get(o1);
           } 
        });
        
        int cnt = 0;
        for(int x : key) {
            cnt += map.get(x);
            answer++;
            if(cnt >= k) break;
        }
        
        return answer;
    }
}