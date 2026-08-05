import java.util.*;

class Solution {
    
    class Node {
        String w;
        int cnt;
        
        Node(String w, int cnt) {
            this.w = w;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        // words에 target이 없는 경우
        boolean exist = false;
        for(String word : words) {
            if(target.equals(word)) {
                exist = true;
                break;
            }
        }
        if(!exist) return 0;
        
        // bfs활용
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.w.equals(target)) 
                return cur.cnt;
            
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                
                if(canChange(cur.w, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], cur.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                diff++;
            
            if(diff > 1) return false;
        }
        
        return true;
    }
}