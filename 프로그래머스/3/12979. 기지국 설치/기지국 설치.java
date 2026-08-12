class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1; // 현재 위치
        int range = w * 2 + 1; // 기지국의 커버 범위
        
        for(int station : stations) {
            // 현재 기지국 이전의 빈 구간
            if(station - w > now) {
                // 현재위치부터 기지국까지 아파트의 수
                int count = station - w - now;
                
                answer += count / range;
                
                if(count % range != 0)
                    answer++;
            }
            
            // 현재 기지국이 커버하는 범위 다음으로 이동
            now = station + w + 1;
        }
        
        // 마지막 기지국 이후의 빈 구간
        if(now <= n) {
            int count = n - now + 1;

            answer += count / range;
            if(count % range != 0)
                answer++;
        }

        return answer;
    }
}