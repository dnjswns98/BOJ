import java.util.*;

public class Solution {
    static int cnt = 0;
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

            tasteMax = 0;
            dfs(0,0,0);

            System.out.print("#" + test_case + " ");
            System.out.println(tasteMax);
        }
    }

    static void dfs(int idx, int currentTaste, int currentCal) {
        if(currentCal > l) {
            return;
        }
        if(idx == n) {
            tasteMax = Math.max(tasteMax,currentTaste);
            return;
        }

        dfs(idx + 1, currentTaste + taste.get(idx), currentCal + cal.get(idx));
        dfs(idx + 1, currentTaste, currentCal);
    }
}
