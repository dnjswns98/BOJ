import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        
        // 시작 시간 기준 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String[] booking : book_time) {
            int start = convert(booking[0]);
            int end = convert(booking[1]) + 10;
            
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            pq.add(end);
        }
        
        return pq.size();
    }
    
    public int convert(String time) {
        String[] s = time.split(":");

        return Integer.parseInt(s[0]) * 60 
            + Integer.parseInt(s[1]);
    }
}