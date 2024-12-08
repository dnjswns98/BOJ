import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,1,-1,-1,0,1};

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            PriorityQueue<Integer> customer = new PriorityQueue<>();
            int maxTime = 0;
            for(int i = 0; i<n; i++) {
                int num = sc.nextInt();
                customer.add(num);
                maxTime = Math.max(maxTime,num);
            }

            if(m > customer.peek()) { //첫 붕어빵이 만들어지기 전에 오는 손님
                System.out.print("#" + test_case + " ");
                System.out.println("Impossible");
                continue;
            }

            boolean isPossible = false;
            int cnt = 0;
            for(int time = m; time<=maxTime; time += m) {
                cnt += k;

                if(cnt >= customer.size()) {
                    isPossible = true;
                    break;
                }

                while(!customer.isEmpty() && customer.peek() >= time && customer.peek() < time+m) {
                    cnt--;
                    customer.remove();
                }
                if(cnt < 0) {
                    break;
                }
            }

            System.out.print("#" + test_case + " ");
            if(isPossible) {
                System.out.println("Possible");
            }
            else {
                System.out.println("Impossible");
            }
        }
    }
}
