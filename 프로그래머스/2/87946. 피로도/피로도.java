import java.util.*;

class Solution {
    int answer;
    
    public int solution(int k, int[][] dungeons) {     
        answer = 0;
        dfs(0, k, dungeons, 0);
        
        return answer;
    }
    
    void dfs(int cnt, int fatigue, int[][] dungeons, int visited) { 
        for(int i = 0; i<dungeons.length; i++) {
            // 방문하지 않았고, 필요도가 가능할때
            if((visited & (1 << i)) == 0 && dungeons[i][0] <= fatigue) {
                dfs(cnt + 1, fatigue - dungeons[i][1], dungeons, visited | (1 << i));
            }
        }
        
        answer = Math.max(answer, cnt);
    }
}