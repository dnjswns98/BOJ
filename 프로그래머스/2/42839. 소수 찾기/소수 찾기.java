import java.util.*;

class Solution {
    
    Set<Integer> set;
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        dfs("", numbers);
        
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void dfs(String current, String numbers) {
        if(!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}