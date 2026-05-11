import java.util.*;

class Solution {
    
    class Node implements Comparable<Node>{
        int v;
        int w;
        
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<Node>[] list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int v1 = road[i][0];
            int v2 = road[i][1];
            int weight = road[i][2];
            
            list[v1].add(new Node(v2, weight));
            list[v2].add(new Node(v1, weight));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for(Node next : list[cur.v]) {
                if(dist[next.v] > next.w + cur.w) {
                    dist[next.v] = next.w + cur.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        for(int d : dist) {
            if(d <= K) answer++;
        }

        return answer;
    }
}