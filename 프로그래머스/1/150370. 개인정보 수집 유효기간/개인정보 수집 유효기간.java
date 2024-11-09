import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        String[] todays = today.split("[.]");
        int[] todayInt = new int[3];
        for(int i = 0; i<todays.length; i++) {
            todayInt[i] = Integer.valueOf(todays[i]);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : terms) {
            String[] str = s.split(" ");
            map.put(str[0], Integer.valueOf(str[1]));
        }
        
        int index = 1;
        for(String s : privacies) {
            String[] str = s.split(" ");
            String term = str[1];
            String[] days = str[0].split("[.]");
            int[] dayInt = new int[3];
            for(int i = 0; i<days.length; i++) {
                dayInt[i] = Integer.valueOf(days[i]);
            }
            
            dayInt[1] += map.get(term);
            if(dayInt[1] > 12) {
                dayInt[0] += dayInt[1] / 12;
                dayInt[1] %= 12;
            }
            if(dayInt[1] == 0) {
                dayInt[0]--;
                dayInt[1] = 12;
            }
            
            if(todayInt[0] == dayInt[0]) {
                if(todayInt[1] == dayInt[1]) {
                    if(todayInt[2] >= dayInt[2]) {
                        list.add(index);
                    }
                }
                else if (todayInt[1] > dayInt[1]) {
                    list.add(index);
                }
            }
            else if(todayInt[0] > dayInt[0]) {
                list.add(index);
            }
            
            index++;
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}