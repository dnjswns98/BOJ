class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int cntTrue = 0;
        int sumIdx = 0;
        
        for(int i = 0; i<included.length; i++){
            if(included[i] == true){
                cntTrue++;
                sumIdx += i;
            }
        }
        answer = cntTrue * a + sumIdx * d;
            
        return answer;
    }
}