import java.util.ArrayList;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        ArrayList<Long> array = new ArrayList<>();
        while(n != 0){
            array.add(n%10);
            n/=10;
        }
        answer = array.stream().mapToInt(Long::intValue).toArray();
        return answer;
    }
}