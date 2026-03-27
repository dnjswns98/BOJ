import java.util.*;

class Solution {
    
    String[] alpha = {"A", "E", "I", "O", "U"};
    boolean find = false;
    int answer = 0;
    
    public int solution(String word) {
        dfs("", word);
        return answer - 1; //최초진입할때 ++됐으니 -1
    }
    
    public void dfs(String current, String word) {
        if(find) return;
        
        answer++;
        
        if(current.equals(word)){
            find = true;
            return;
        }
        
        if(current.length() >= 5) return;
        
        for(String s : alpha) {
            dfs(current + s, word);
        }
    }
}