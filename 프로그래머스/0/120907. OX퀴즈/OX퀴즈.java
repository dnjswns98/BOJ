class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length]; 
        
        int i = 0;
        for(String s : quiz){
            String[] temp = s.split(" ");
            
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[2]);
            String operator = temp[1];
            int result = Integer.parseInt(temp[4]);
            
            if(operator.equals("+") && first + second == result){
                answer[i++] = "O";
            }
            else if(operator.equals("-") && first - second == result){
                answer[i++] = "O";
            }
            else{
                answer[i++] = "X";
            }
        }
        
        
        return answer;
    }
}