import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                answer++;
                bfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public void bfs(int v, int size, int[][] map) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            
            for(int i = 0; i<size; i++){
                if(map[cur][i] == 1 && !visited[i]){
                    q.offer(i);
                }
            }
        }
    }
}