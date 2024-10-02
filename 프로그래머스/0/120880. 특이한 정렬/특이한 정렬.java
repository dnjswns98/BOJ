class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[] dist = new int[numlist.length];
        int resultIdx = 0;
        
        for(int i = 0; i<numlist.length; i++){
            dist[i] = Math.abs(n - numlist[i]);
        }
        
        for(int i = 0; i<numlist.length; i++){
            int min = 99999;
            int idx = -1;
            
            for(int j = 0; j<numlist.length; j++){
                if(dist[j] == -1) continue;
                
                if(min > dist[j]){
                    min = dist[j];
                    idx = j;
                } 
                else if(dist[j] == min && numlist[idx] < numlist[j]){
                    min = dist[j];
                    idx = j;
                }
            }
            
            dist[idx] = -1;
            answer[resultIdx++] = numlist[idx];
        }
        
        
        return answer;
    }
}