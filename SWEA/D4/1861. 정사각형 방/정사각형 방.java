import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int num = 0;
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = dfs(i,j);
					if(max < cnt) { //max값 갱신
						max = cnt;
						num = arr[i][j];
					}
					else if(max == cnt && arr[i][j] < num) //cnt가 같고 방 번호가 더 작다면
						num = arr[i][j];
				}
			}

			System.out.println("#" + test + " " + num + " " + max);
		}
	}

	static int dfs(int x, int y) {
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isValid(nx, ny) && arr[x][y] + 1 == arr[nx][ny]) {
				cnt += Math.max(cnt, dfs(nx, ny));
			}
		}
		
		return cnt;
	}

	static boolean isValid(int nx, int ny) {
		if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
			return false;
		}
		return true;
	}
}