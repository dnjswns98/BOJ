import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        int dist;
        
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int t = 0; t < 5; t++) {
            boolean isSafe = true;
            
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    // 사람 발견
                    if(places[t][i].charAt(j) == 'P') {
                        // 거리두기 검사
                        if(!bfs(i, j, places[t])) {
                            isSafe = false;
                            break;
                        }
                    }
                }
                
                if(!isSafe) break;
            }
            
            answer[t] = isSafe ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean bfs(int x, int y, String[] place) {
        Deque<Point> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        dq.offer(new Point(x, y, 0));
        visited[x][y] = true;
        
        while(!dq.isEmpty()) {
            Point cur = dq.poll();
            
            for(int i = 0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                
                if(cur.dist + 1 > 2) continue;
                
                visited[nx][ny] = true;
                
                // 다른 사람과 인접
                if(place[nx].charAt(ny) == 'P') 
                    return false;
                
                // 빈테이블이면 계속 탐색
                if(place[nx].charAt(ny) == 'O') {
                    dq.offer(new Point(nx, ny, cur.dist + 1));
                }
                
                // 파티션(x)는 탐색 안 함
            }
        }
        
        return true;
    }
}