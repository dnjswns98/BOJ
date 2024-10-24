import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        int cur_idx = 0;
        int pre_idx = 0;
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                answer[cur_idx] = cur_idx - map.get(c);
            } else {
                answer[cur_idx] = -1;
            }
            map.put(c,cur_idx);
            cur_idx++;
        }
        
        return answer;
    }
}