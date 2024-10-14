class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] chk = new boolean[n + 1];
        
        for(int i = 0; i<section.length; i++){
            //덧칠 할 부분이 칠해져있지 않다면
            if(!chk[section[i]]){
                //덧칠 할 시작 부분에서 롤러의 크기가 벽의 범위를 벗어나면
                if(section[i] + m > n + 1){
                    for(int j = section[i]; j<=n; j++){
                        chk[j] = true;
                    }
                    answer++;
                }
                else{
                    for(int j = section[i]; j<section[i] + m; j++){
                        chk[j] = true;
                    }
                    answer++;
                }
            }
        }
        
        return answer;
    }
}