class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true;
        for(char c : s.toCharArray()) {
            if(isFirst) {
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(Character.toLowerCase(c));
            }
            
            isFirst = (c == ' ');
        }

        return sb.toString();
    }
}