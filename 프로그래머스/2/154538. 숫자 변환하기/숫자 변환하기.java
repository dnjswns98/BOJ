import java.util.*;

class Solution {
    
    class Node {
        int x;
        int cnt;
        
        Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    public int solution(int x, int y, int n) {   
        if(x == y) return 0;
        
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, 0));
        
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;
        
        while(!dq.isEmpty()) {
            Node cur = dq.poll();
            
            int[] nextNum = {cur.x + n, cur.x * 2, cur.x * 3};
            for(int next : nextNum) {
                if(next > y || visited[next]) continue;
                
                if(next == y) return cur.cnt + 1;

                visited[next] = true;
                dq.add(new Node(next, cur.cnt + 1));
            }
        }
        
        return -1;
    }
}