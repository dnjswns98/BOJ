import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for(int i = 1; i<arr.length; i++){
            if(s.peek() != arr[i]){
                s.push(arr[i]);
            }
        }
        
        int[] answer = new int[s.size()];
        // 스택에서 배열로 값을 옮기기 (역순이 아님)
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = s.pop();  // 스택의 맨 위 원소를 꺼내서 배열에 저장
        }

        return answer;
    }
}