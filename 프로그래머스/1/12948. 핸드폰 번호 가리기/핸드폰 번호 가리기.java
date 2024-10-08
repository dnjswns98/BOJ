class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int size = phone_number.length();
        for(int i = 0; i<size-4; i++){
            answer += "*";
        }
        for(int i = 0; i<4; i++){
            answer += phone_number.charAt(size-4);
            size++;
        }
        
        return answer;
    }
}