import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int result = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int dx = -n; dx < n; dx++) { // 행 공차
					for (int dy = -m; dy < m; dy++) { // 열 공차
						if (dx == 0 && dy == 0)
							continue;
						
						int t = 0;
						int nx = i;
						int ny = j;
						while(nx >= 0 && nx < n && ny >= 0 && ny < m) {
							t = 10 * t + arr[nx][ny];
							
							int sqrt = (int) Math.sqrt(t);
							if(sqrt * sqrt == t) {
								result = Math.max(result, t);
							}
							
							nx += dx;
							ny += dy;
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
