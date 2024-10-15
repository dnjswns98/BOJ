import java.util.*;

class Solution {
    public List<String> solution(String[] players, String[] callings) {
        //현재등수기록
        HashMap<String, Integer> hm = new HashMap<>();
        //추월한 결과 넣기
        List<String> list = new ArrayList<>(Arrays.asList(players));
        
        //초기 등수 기록
        for (int i = 0; i < players.length; i++) {
            hm.put(players[i], i);
        }
        
        for(String called : callings){
            //추월한 선수의 현재 등수
            int currentRank = hm.get(called);
            //추월당한 선수 이름
            String front = list.get(currentRank - 1);
            
            //두 선수 교환
            list.set(currentRank - 1, called);
            list.set(currentRank, front);
            
            hm.put(called, currentRank - 1);
            hm.put(front, currentRank);
        }
        
        return list;
    }
}