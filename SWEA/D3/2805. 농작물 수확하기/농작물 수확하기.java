import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int sum = 0;
            String[] map = new String[n];
            for(int i = 0; i<n; i++) {
                map[i] = sc.next();
            }

            for(int i = 0; i<n; i++) {
                if(i <= n/2) {
                    for (int j = n / 2 - i; j <= n / 2 + i; j++) {
                        sum += map[i].charAt(j) - '0';
                    }
                }
                else {
                    for (int j = i - n / 2; j < n + n/2 - i; j++) {
                        sum += map[i].charAt(j) - '0';
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(sum);
        }
    }
}
