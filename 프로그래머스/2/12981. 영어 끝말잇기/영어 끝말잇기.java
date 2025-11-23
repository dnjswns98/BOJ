import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        set.add(words[0]);
  
        for(int i = 1; i<words.length; i++) {
            if(set.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i-1].length() - 1)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            set.add(words[i]);
        }

        return answer;
    }
}