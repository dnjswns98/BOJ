class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int Cur_x = 0;
        int Cur_y = 0;
        for(int i = 0; i<park.length; i++){
            for(int j = 0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    Cur_x = i;
                    Cur_y = j;
                }
            }
        }

        
        for(String s : routes){
            int n = s.charAt(2) - '0';
            boolean chk = true;
            if(s.charAt(0) == 'E' && Cur_y + n < park[0].length()){
                for(int i = Cur_y + 1; i <= Cur_y + n; i++){
                    if(park[Cur_x].charAt(i) == 'X'){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    Cur_y += n;
                }
            }
            else if(s.charAt(0) == 'W' && Cur_y - n >= 0){
                for(int i = Cur_y - 1; i >= Cur_y - n; i--){
                    if(park[Cur_x].charAt(i) == 'X'){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    Cur_y -= n;
                }
            }
            else if(s.charAt(0) == 'S' && Cur_x + n < park.length){
                for(int i = Cur_x + 1; i <= Cur_x + n; i++){
                    if(park[i].charAt(Cur_y) == 'X'){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    Cur_x += n;
                }
            }
            else if(s.charAt(0) == 'N' && Cur_x - n >= 0){
                for(int i = Cur_x - 1; i >= Cur_x - n; i--){
                    if(park[i].charAt(Cur_y) == 'X'){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    Cur_x -= n;
                }
            }
            //System.out.print(Cur_x);
            //System.out.println(Cur_y);
        }

        
        answer[0] = Cur_x;
        answer[1] = Cur_y;
        return answer;
    }
}