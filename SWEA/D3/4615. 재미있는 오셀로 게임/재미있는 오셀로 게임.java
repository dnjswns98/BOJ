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
            int[][] arr = new int[n][n];
            arr[n/2][n/2] = 2;
            arr[n/2-1][n/2-1] = 2;
            arr[n/2][n/2-1] = 1;
            arr[n/2-1][n/2] = 1;

            for(int i = 0; i<m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int color = sc.nextInt();
                arr[x][y] = color;

                for(int j = 0; j<8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    boolean valid = false;

                    while(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != 0) {
                        if(arr[nx][ny] == color) {
                            valid = true;
                            break;
                        }
                        nx += dx[j];
                        ny += dy[j];
                    }

                    if(valid) {
                        int pre_x = x + dx[j];
                        int pre_y = y + dy[j];

                        while(!(pre_x == nx && pre_y == ny)) {
                            arr[pre_x][pre_y] = color;
                            pre_x += dx[j];
                            pre_y += dy[j];
                        }
                    }
                }
            }

            int black = 0;
            int white = 0;
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(arr[i][j] == 1) black++;
                    else if(arr[i][j] == 2) white++;
                }
            }

            System.out.print("#" + test_case + " ");
            System.out.println(black + " " + white);
        }
    }
}
