import java.util.*;

public class Solution {
    static int n;
    static int l;
    static int tasteMax = 0;
    static List<Integer> taste;
    static List<Integer> cal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            Deque<Integer> dq = new LinkedList<>();
            for(int i = 0; i<8; i++) {
                dq.add(sc.nextInt());
            }

            int cnt = 1;
            while(true) {
                int num = dq.remove() - cnt;
                if(num <= 0) {
                    dq.add(0);
                    break;
                }
                dq.add(num);
                cnt++;

                if(cnt == 6) {
                    cnt = 1;
                }
            }

            System.out.print("#" + test_case + " ");
            while(!dq.isEmpty()) {
                System.out.print(dq.remove() + " ");
            }
            System.out.println();
        }
    }
}
