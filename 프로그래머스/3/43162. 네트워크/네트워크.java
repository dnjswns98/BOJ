import java.util.*;

class Solution {
    
    int[] parents;
    HashSet<Integer> set = new HashSet<>();
    
    public int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    
    public boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot == bRoot) return false;
        
        parents[bRoot] = aRoot;
        return true;
    }
    
    public int solution(int n, int[][] computers) {
        
        parents = new int[n];
        for(int i = 0; i<n; i++){
            parents[i] = i;
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i==j) continue;
                
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        for(int i = 0; i<n; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
}