class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        answer += "김서방은 ";
        int idx = 0;
        for(String s : seoul){
            if(s.equals("Kim")){
                break;
            }
            idx++;
        }
        answer += idx + "에 있다";
        return answer;
    }
}