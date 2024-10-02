import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for(int i = l; i<=r; i++){
            String s = String.valueOf(i);
            char[] num = s.toCharArray();
            boolean chk = true;

            for(int j = 0; j<num.length; j++){
                if(num[j] != '0' && num[j] != '5'){
                    chk = false;
                    break;
                }
            }
            if(chk){
                list.add(i);
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        if(answer.length == 0){
            answer = new int[] {-1};
        }
        
        return answer;
    }
}