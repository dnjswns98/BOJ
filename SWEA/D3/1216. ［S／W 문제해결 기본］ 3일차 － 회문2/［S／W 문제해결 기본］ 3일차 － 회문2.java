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
            
            String[] colStr = new String[100]; //세로 저장
            for(int i = 0; i<100; i++) {
                String s = "";
                for(int j = 0; j<100; j++) {
                    s += str[j].charAt(i);
                }
                colStr[i] = s;
            }
            
            int result = 1;
            for(int i = 0; i < 100; i++) { //가로 회문 검사
                for(int j = 0; j < 99; j++) {
                    for(int h = j + 1; h < 100; h++) {
                        if((h - j) % 2 == 1) { //짝수개
                            String s1 = str[i].substring(j, (j + h + 1) / 2);
                            String s2 = str[i].substring((j + h + 1) / 2, h + 1);
                            String reverse = new StringBuilder(s2).reverse().toString();
                            if(s1.equals(reverse)) {
                                result = Math.max(result, s1.length() * 2);
                            }
                        }
                        else { //홀수개
                            String s1 = str[i].substring(j, (j + h) / 2);
                            String s2 = str[i].substring((j + h) / 2 + 1, h + 1);
                            String reverse = new StringBuilder(s2).reverse().toString();
                            if(s1.equals(reverse)) {
                                result = Math.max(result, s1.length() * 2 + 1);
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < 100; i++) { //세로 회문 검사
                for(int j = 0; j < 99; j++) {
                    for(int h = j + 1; h < 100; h++) {
                        if((h - j) % 2 == 1) { //짝수개
                            String s1 = colStr[i].substring(j, (j + h + 1) / 2);
                            String s2 = colStr[i].substring((j + h + 1) / 2, h + 1);
                            String reverse = new StringBuilder(s2).reverse().toString();
                            if(s1.equals(reverse)) {
                                result = Math.max(result, s1.length() * 2);
                            }
                        }
                        else { //홀수개
                            String s1 = colStr[i].substring(j, (j + h) / 2);
                            String s2 = colStr[i].substring((j + h) / 2 + 1, h + 1);
                            String reverse = new StringBuilder(s2).reverse().toString();
                            if(s1.equals(reverse)) {
                                result = Math.max(result, s1.length() * 2 + 1);
                            }
                        }
                    }
                }
            }

            System.out.print("#" + n + " ");
            System.out.println(result);
        }
    }
}
