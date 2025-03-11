import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static int n;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int start, int now, int depth, int sum) {
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                result = Math.min(result, sum);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[now][i] > 0) {
                visited[i] = true;
                dfs(start, i, depth + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}