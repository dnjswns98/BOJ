import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] arr;
	static int ans, yCnt, check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		ans = 0;
		result = new int[7];
		comb(0, 0, 0);

		System.out.println(ans);
	}

	static void comb(int cnt, int start, int yCnt) {
		// 'Y'가 4명 이상이면 생존 조건을 만족하지 않음
		if (yCnt >= 4)
			return;

		if (cnt == 7) {
			visited = new boolean[7];
			visited[0] = true;
			check = 1;
			dfs(result[0] / 5, result[0] % 5);
			
			// 7명이 모두 연결되어 있다면
			if(check == 7) ans++;
			
			return;
		}

		// 5 * 5 인 2차원배열을 일차원으로 표현 (0~24)
		for (int i = start; i < 25; i++) {
			result[cnt] = i;
			if (arr[i / 5][i % 5] == 'Y')
				comb(cnt + 1, i + 1, yCnt + 1);
			else
				comb(cnt + 1, i + 1, yCnt);
		}
	}

	static void dfs(int x, int y) {	
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			
			for(int j = 0; j<7; j++) {
				if(visited[j]) continue;
				
				if(result[j] == nx * 5 + ny) {
					visited[j] = true;
					check++;
					dfs(nx, ny);
				}
			}
			
		}
	}
}