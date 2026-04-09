import java.util.*;

class Solution {
    
    class Truck {
        int w;
        int t; // 트럭이 들어간 시간
        
        Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int sum = 0;
        Deque<Truck> dq = new ArrayDeque<>();
        
        for(int w : truck_weights) {      
            if(!dq.isEmpty() && dq.peek().t + bridge_length <= time) {
                sum -= dq.poll().w;
            }
            
            // 들어갈 트럭의 무게와 현재 들어간 트럭의 무게의 합이 기준치 보다 높다면
            // 들어간 트럭이 나와야 새로운 트럭이 들어갈 수 있음
            while(sum + w > weight) {
                Truck truck = dq.poll();
                sum -= truck.w;
                time = truck.t + bridge_length;
            }
            
            dq.add(new Truck(w, time));
            sum += w;
            time++;
        }
        
        return dq.pollLast().t + bridge_length;
    }
}