import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            String[] str = new String[8];
            for(int i = 0; i<8; i++) {
                str[i] = sc.next();
            }

            int cnt = 0;
            for(int i = 0; i < 8; i++) { //가로 회문 찾기
                for(int j = 0; j <= 8 - n; j++) {
                    String origin = str[i].substring(j,j+n);
                    StringBuffer sb = new StringBuffer(origin);
                    String reverse = sb.reverse().toString();
                    if(origin.equals(reverse)) {
                        cnt++;
                    }
                }
            }

            for(int i = 0; i < 8; i++) { //세로 회문 찾기
                for(int j = 0; j <= 8 - n; j++) {
                    String origin = "";
                    for(int h = j; h < j + n; h++) {
                        origin = origin + str[h].charAt(i);
                    }
                    StringBuffer sb = new StringBuffer(origin);
                    String reverse = sb.reverse().toString();
                    if(origin.equals(reverse)) {
                        cnt++;
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(cnt);
        }
    }
}