class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i = 0; i<photo.length; i++){
            for(int j = 0; j<photo[i].length; j++){
                for(int h = 0; h<name.length; h++){
                    if(photo[i][j].equals(name[h])){
                        answer[i] += yearning[h];
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}