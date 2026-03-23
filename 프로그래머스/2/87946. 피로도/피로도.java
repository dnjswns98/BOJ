import java.util.*;

class Solution {
    
    boolean[] visited;
    int answer;
    
    public int solution(int k, int[][] dungeons) {     
        visited = new boolean[dungeons.length];
        answer = 0;
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    void dfs(int cnt, int fatigue, int[][] dungeons) { 
        for(int i = 0; i<dungeons.length; i++) {
            // 방문하지 않았고, 필요도가 가능할때
            if(!visited[i] && dungeons[i][0] <= fatigue) {
                visited[i] = true;
                dfs(cnt + 1, fatigue - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
}