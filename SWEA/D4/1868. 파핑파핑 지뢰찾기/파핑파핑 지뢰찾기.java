import java.util.Scanner;

class Solution {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result = 0;
            n = sc.nextInt();
            arr = new char[n][n];
            visited = new boolean[n][n];
            for(int i = 0; i<n; i++) {
                String s = sc.next();
                for(int j = 0; j<n; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            checkBomb();

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(arr[i][j] == '0' && !visited[i][j]) {
                        dfs(i,j);
                        result++;
                    }
                }
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(arr[i][j] != '0' && arr[i][j] != '*' && !visited[i][j]) {
                        result++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    public static void checkBomb() {
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                if(arr[i][j] == '.') {
                    int cnt = 0;
                    for(int h = 0; h<8; h++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];
                        if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == '*')
                            cnt++;
                    }
                    arr[i][j] = (char)(cnt + '0');
                }
            }
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        if(arr[i][j] == '0') {
            for(int h = 0; h < 8; h++) {
                int nx = i + dx[h];
                int ny = j + dy[h];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != '*' && !visited[nx][ny]) {
                    dfs(nx,ny);
                }
            }
        }
    }
}