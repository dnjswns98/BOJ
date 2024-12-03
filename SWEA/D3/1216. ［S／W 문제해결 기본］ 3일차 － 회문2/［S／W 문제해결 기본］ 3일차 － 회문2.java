import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T=sc.nextInt();

        for(int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            String[] str = new String[100];
            for(int i = 0; i<100; i++) {
                str[i] = sc.next();
            }
            
            int result = 1;
            for(int i = 0; i<100; i++) {
                for(int j = 0; j<99; j++) {
                    for(int h = j + 1; h<100; h++) {
                        if(isRowPalindrome(str[i], j, h)) {
                            result = Math.max(result, h - j + 1);
                        }
                        if(isColPalindrome(str, i, j, h)) {
                            result = Math.max(result, h - j + 1);
                        }
                    }
                }
            }

            System.out.print("#" + n + " ");
            System.out.println(result);
        }
    }

    static boolean isRowPalindrome(String str, int start, int end) {
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static boolean isColPalindrome(String[] str, int col, int start, int end) {
        while(start < end) {
            if(str[start].charAt(col) != str[end].charAt(col)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
