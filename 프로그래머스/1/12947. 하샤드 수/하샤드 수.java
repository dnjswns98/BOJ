class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String[] s = String.valueOf(x).split("");
        for(int i = 0; i<s.length; i++){
            sum += Integer.valueOf(s[i]);
        }
        if(x%sum != 0) answer = false;
        
        return answer;
    }
}