class Solution {
    public int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i<10; i++){
            s = s.replaceAll(num[i], String.valueOf(i));
        }
        
        if(s.charAt(0) == '0') s = s.substring(1);
        int answer = Integer.parseInt(s);
        
        return answer;
    }
}