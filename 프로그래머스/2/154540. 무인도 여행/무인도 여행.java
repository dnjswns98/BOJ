import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1 ,0, 1};
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    answer.add(dfs(i, j, maps));
                }
            }
        }
        
        if(answer.isEmpty()) return new int[] {-1};
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int dfs(int x, int y, String[] maps) {
        visited[x][y] = true;
        
        int sum = maps[x].charAt(y) - '0';
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length())
                continue;
            
            if(maps[nx].charAt(ny) == 'X' || visited[nx][ny]) 
                continue;
            
            sum += dfs(nx, ny, maps);
        }
        
        return sum;
    }
}