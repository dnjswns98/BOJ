class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = new int[4];
        
        for(int i = 0; i<survey.length; i++) {
            String s = survey[i];
            if(s.equals("RT")) score[0] -= choices[i] - 4;
            else if(s.equals("CF")) score[1] -= choices[i] - 4;
            else if(s.equals("JM")) score[2] -= choices[i] - 4;
            else if(s.equals("AN")) score[3] -= choices[i] - 4;
            
            else if(s.equals("TR")) score[0] += choices[i] - 4;
            else if(s.equals("FC")) score[1] += choices[i] - 4;
            else if(s.equals("MJ")) score[2] += choices[i] - 4;
            else if(s.equals("NA")) score[3] += choices[i] - 4;
        }
        
        StringBuilder sb = new StringBuilder();
        if(score[0] >= 0) sb.append('R'); else sb.append('T');
        if(score[1] >= 0) sb.append('C'); else sb.append('F');
        if(score[2] >= 0) sb.append('J'); else sb.append('M');
        if(score[3] >= 0) sb.append('A'); else sb.append('N');
        
        return sb.toString();
    }
}