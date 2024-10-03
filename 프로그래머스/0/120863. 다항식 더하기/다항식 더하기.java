class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] str = polynomial.split(" ");
        int num = 0;
        int x_num = 0;

        for(String s : str){
            //일차항
            if(s.contains("x")){
                if(s.length() == 1) { //x
                    x_num++;
                }
                else { //nx
                    String temp = s.replace("x", "");
                    x_num += Integer.valueOf(temp);
                }
            }
            //연산자
            else if(s.equals("+")){
                continue;
            }
            //상수항
            else{
                num += Integer.valueOf(s);
            }
        }
        
        if(x_num == 0){
            answer += num;
        }
        else if(num == 0){
            if(x_num == 1) 
                answer += "x";
            else 
                answer += x_num + "x";
        }
        else{
            if(x_num == 1) 
                answer += "x + " + num;
            else answer += x_num + "x + " + num;
        }
        
        return answer;
    }
}