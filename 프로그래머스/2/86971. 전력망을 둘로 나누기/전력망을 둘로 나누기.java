import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    int answer = Integer.MAX_VALUE;
    int n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        
        graph = new ArrayList[n + 1];
        for(int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        dfs(1, 0);
        
        return answer;
    }
    
    // subtree 사이즈 반환
    public int dfs(int node, int parent) {
        int size = 1; // 자기 자신 포함
        
        for(int next : graph[node]) {
            if(next == parent) continue;
            
            int childSize = dfs(next, node);
            
            // childSize = 한쪽 그룹 크기
            // n - childSize = 나머지
            // (n - childSize) - childSize = 두 그룹의 차
            answer = Math.min(answer, Math.abs(n - 2 * childSize));
            size += childSize;
        }
        
        return size;
    }
}