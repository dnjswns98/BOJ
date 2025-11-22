class Solution {
    public String solution(int a, int b) {
        
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED", };
        
        int cnt = 0;
        for(int i = 0; i < a - 1; i++) {
            cnt += month[i];
        }
        cnt += b;
        
        return day[cnt % 7];
    }
}