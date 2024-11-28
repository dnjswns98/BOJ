import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int cnt = 0;
            int[][] arr = new int[100][100];
            for(int i = 0; i<100; i++) {
                for(int j = 0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < 100; i++) {
                boolean check_n = false;
                boolean check_s = false;

                for(int j = 0; j < 100; j++) {
                    if(arr[j][i] == 1) {
                        check_n = true;
                    }
                    else if(arr[j][i] == 2) {
                        check_s = true;
                    }

                    if(!check_n && check_s) {
                        check_s = false;
                    }
                    else if(check_n && check_s) {
                        cnt++;
                        check_s = false;
                        check_n = false;
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }
}