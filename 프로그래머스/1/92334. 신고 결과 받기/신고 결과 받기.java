import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> id = new HashMap<>();
        for(int i = 0; i<id_list.length; i++) {
            id.put(id_list[i], i);
        }
        
        int[][] report_to = new int[id_list.length][id_list.length];
        int[] receivedCnt = new int[id_list.length];
        for(int i = 0; i<report.length; i++) {
            String[] person = report[i].split(" ");
            
            if(report_to[id.get(person[0])][id.get(person[1])] == 0) {
                report_to[id.get(person[0])][id.get(person[1])]++;
                receivedCnt[id.get(person[1])]++;
            }
        }
        
        for(int i = 0; i<id_list.length; i++) {
            if(receivedCnt[i] >= k) {
                for(int j = 0; j<id_list.length; j++) {
                    if(report_to[j][i] > 0) answer[j]++;
                }
            }
        }
        
        return answer;
    }
}