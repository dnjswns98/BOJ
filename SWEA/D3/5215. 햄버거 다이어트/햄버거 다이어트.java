import java.util.*;

public class Solution {
    static int n;
    static int l;
    static int tasteMax = 0;
    static List<Integer> taste;
    static List<Integer> cal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();
            taste = new ArrayList<>();
            cal = new ArrayList<>();
            for(int i = 0; i<n; i++) {
                taste.add(sc.nextInt());
                cal.add(sc.nextInt());
            }
            int[] dp = new int[l + 1];

            for(int i = 0; i<n; i++) {
                for(int j = l; j >= cal.get(i); j--) {
                    dp[j] = Math.max(dp[j], dp[j - cal.get(i)] + taste.get(i));
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(dp[l]);
        }
    }
}
