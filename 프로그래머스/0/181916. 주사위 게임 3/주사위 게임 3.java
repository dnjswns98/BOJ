import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] num = {a,b,c,d};
        
        Arrays.sort(num); //정렬
        
        if(num[0] == num[3]){ //모두 같음
            answer = 1111 * a;
        }
        else if(num[0] == num[2] || num[1] == num[3]){ //3개 같은 부분
            int p = num[2]; //겹치는 부분
            int q = num[0] + num[3] - num[2];
            answer = (int)Math.pow(10 * p + q, 2);
        }
        else if(num[0] == num[1] && num[2] == num[3]){ //2개씩 같음
            answer = (num[0] + num[2]) * (num[2] - num[0]);
        }
        else if(num[0] == num[1]){
            answer = num[2] * num[3];
        }
        else if(num[1] == num[2]){
            answer = num[0] * num[3];
        }
        else if(num[2] == num[3]){
            answer = num[0] * num[1];
        }
        else{
            answer = num[0];
        }
        
        return answer;
    }
}