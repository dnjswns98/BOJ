import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations) {
            String[] s = op.split(" ");
            String command = s[0];
            int num = Integer.parseInt(s[1]);
            
            // 삽입
            if(command.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // 삭제
            else {
                // 비어있으면 무시
                if(map.isEmpty()) continue;
                
                if(num == 1) {
                    delete(map, map.lastKey());
                }
                else {
                    delete(map, map.firstKey());
                }
            }
        }
        
        if(map.isEmpty()) return new int[]{0, 0};
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
    
    public void delete(TreeMap<Integer, Integer> map, int key) {
        int cnt = map.get(key);
        
        if(cnt == 1) {
            map.remove(key);
        }
        else {
            map.put(key, cnt - 1);
        }
    }
}