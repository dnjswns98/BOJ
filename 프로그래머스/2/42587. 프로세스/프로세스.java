import java.util.*;

class Solution {
    
    class Node{
        int a;
        int p;
        
        Node(int a, int b) {
            this.a = a;
            this.p = b;
        }
    }
    
    public int solution(int[] priorities, int location) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Node> dq = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            list.add(priorities[i]);
            dq.add(new Node(i, priorities[i]));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int cnt = 0;
        int idx = 0;
        while(!dq.isEmpty()) {
            Node n = dq.poll();
            
            if(n.p == list.get(idx)) {
                idx++;
                cnt++;
                if(location == n.a){
                    return cnt;
                }
            }
            else dq.add(n);
        }

        return 0;
    }
}