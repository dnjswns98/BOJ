class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] str = polynomial.split(" ");
        int num = 0;
        int x_num = 0;

        for(String s : str){
            //일차항 처리
            if(s.contains("x")){
                if(s.length() == 1) { //x의 계수가 1인 경우
                    x_num++;
                }
                else { //nx
                    String temp = s.replace("x", "");
                    x_num += Integer.valueOf(temp);
                }
            }
            //연산자는 건너뜀
            else if(s.equals("+")){
                continue;
            }
            //상수항 처리
            else{
                num += Integer.valueOf(s);
            }
        }
        
         // 일차항이 존재하는 경우
        if (x_num > 0) {
            if (x_num == 1) { // 계수가 1인 경우 생략
                answer += "x";
            } else {
                answer += x_num + "x";
            }
        }

        // 상수항이 존재하는 경우
        if (num > 0) {
            if (x_num > 0) { // 일차항과 상수항 모두 있는 경우
                answer += " + " + num;
            } else { // 상수항만 있는 경우
                answer += num;
            }
        }
        
        return answer;
    }
}