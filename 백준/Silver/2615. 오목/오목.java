import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[] dx = { -1, 1, 1, 0 }; // 우상, 하, 우하, 우
	static int[] dy = { 1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (arr[i][j] != 0) {
					if(dfs(i, j, arr[i][j])) {
						return;
					}
				}
			}
		}
		
		System.out.println(0);
	}

	static boolean dfs(int x, int y, int v) {
		for(int i = 0; i < 4; i++) {
			int cnt = 1;
			for (int j = 1; j <= 5; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				
				if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19 || arr[nx][ny] != v) {
					break;
				}
				
				cnt++;
			}
			
			if(cnt == 5) {
				int nx = x - dx[i];
				int ny = y - dy[i];
				if (nx < 0 || ny < 0 || nx >= 19 || ny >= 19 || arr[nx][ny] != v) {
					System.out.println(v);
					System.out.println((x+1) + " " + (y+1));
					return true;
				}
				
			}
		}
		return false;
	}
}
