import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < 100; i++) {
                int num;
                num = sc.nextInt();
                list.add(num);
            }
            Collections.sort(list);

            for(int i = 0; i<n; i++) {
                list.set(99,list.get(99)-1);
                list.set(0,list.get(0)+1);
                Collections.sort(list);
            }

            System.out.print("#" + test_case + " ");
            System.out.println(list.get(99) - list.get(0));
        }
    }
}