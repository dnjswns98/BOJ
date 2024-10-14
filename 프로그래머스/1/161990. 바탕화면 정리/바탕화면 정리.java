import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        //시작점은 제일 작아야하고 끝점은 제일 커야하니까 비교시 문제 없게 초기화
        int[] answer = {50,50,0,0};
        
        for(int i = 0; i<wallpaper.length; i++){
            int j = 0;
            for(char c : wallpaper[i].toCharArray()){
                if(c == '#'){
                    answer[0] = Math.min(answer[0],i);
                    answer[1] = Math.min(answer[1],j);
                    answer[2] = Math.max(answer[2],i+1);
                    answer[3] = Math.max(answer[3],j+1);
                }
                j++;
            }
        }
        
        return answer;
    }
}