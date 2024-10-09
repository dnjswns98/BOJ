class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int r_max = 0;
        int c_max = 0;
        for(int[] i : sizes){
            r_max = Math.max(r_max,i[0]);
            c_max = Math.max(c_max,i[1]);
        }
        answer = r_max * c_max;
        
        return answer;
    }
}