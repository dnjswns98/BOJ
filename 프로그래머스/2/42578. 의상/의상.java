import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 종류별 갯수 count
        // 각 종류별 옷을 입지 않는 경우의 수가 있기 때문에 + 1
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        for(String cloth : map.keySet()) {
            answer *= map.get(cloth);
        }
        
        // 하나도 입지 않은 경우 빼기
        return answer - 1;
    }
}