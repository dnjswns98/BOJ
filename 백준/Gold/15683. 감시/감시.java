import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, zeroCnt, tempCnt, min;
	static int[][] arr, temp;
	static int[] direction;
	static ArrayList<Point> cctv;
	static int[] dx = { -1, 0, 1, 0 }; // 시계방향 12 -> 3 -> 6 -> 9
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x;
		int y;
		int type;

		public Point(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		zeroCnt = 0;
		arr = new int[n][m];
		cctv = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 0) // 빈 공간
					zeroCnt++;
				else if (arr[i][j] != 6) // cctv
					cctv.add(new Point(i, j, arr[i][j])); // 위치와 type(1~5) 저장
			}
		}

		min = zeroCnt;
		direction = new int[cctv.size()]; // 각 cctv의 방향을 저장할 변수
		comb(0);

		System.out.println(min);
	}

	static void comb(int idx) {
		if (idx == cctv.size()) { // 모든 cctv의 방향을 결정했다면
			temp = new int[n][m]; // 기존 맵 복사
			for (int i = 0; i < n; i++) {
				temp[i] = arr[i].clone();
			}

			tempCnt = zeroCnt;
			int i = 0;
			for (Point p : cctv) { // 방향에 따라 cctv 동작시키기
				work(p, direction[i++]);
			}
			
			min = Math.min(min, tempCnt);
			return;
		}

		// cctv가 4방향 중 어디를 바라볼건지
		// 0 : 상, 1 : 우, 2 : 하, 3 : 좌
		for (int i = 0; i < 4; i++) {
			direction[idx] = i;
			comb(idx + 1);
		}
	}

	static void work(Point p, int dir) {
		switch (p.type) { // cctv 타입에 따라 동작
		case 1:
			if (dir == 0) dfs(p.x, p.y, dir); // 상
			if (dir == 1) dfs(p.x, p.y, dir); // 우
			if (dir == 2) dfs(p.x, p.y, dir); // 하
			if (dir == 3) dfs(p.x, p.y, dir); // 좌
			break;
		case 2:
			if(dir == 0 || dir == 2) {
				dfs(p.x, p.y, 0);
				dfs(p.x, p.y, 2);
			}
			else {
				dfs(p.x, p.y, 1);
				dfs(p.x, p.y, 3);
			}
			break;
		case 3:
			if(dir == 0) {
				dfs(p.x, p.y, 0);
				dfs(p.x, p.y, 1);
			}
			else if(dir == 1) {
				dfs(p.x, p.y, 1);
				dfs(p.x, p.y, 2);
			}
			else if(dir == 2) {
				dfs(p.x, p.y, 2);
				dfs(p.x, p.y, 3);
			}
			else {
				dfs(p.x, p.y, 3);
				dfs(p.x, p.y, 0);
			}
			break;
		case 4:
			if(dir == 0) {
				dfs(p.x, p.y, 0);
				dfs(p.x, p.y, 1);
				dfs(p.x, p.y, 2);
			}
			else if(dir == 1) {
				dfs(p.x, p.y, 1);
				dfs(p.x, p.y, 2);
				dfs(p.x, p.y, 3);
			}
			else if(dir == 2) {
				dfs(p.x, p.y, 2);
				dfs(p.x, p.y, 3);
				dfs(p.x, p.y, 0);
			}
			else if(dir == 3) {
				dfs(p.x, p.y, 3);
				dfs(p.x, p.y, 0);
				dfs(p.x, p.y, 1);
			}
			break;
		case 5:
			dfs(p.x, p.y, 0);
			dfs(p.x, p.y, 1);
			dfs(p.x, p.y, 2);
			dfs(p.x, p.y, 3);
			break;
		}
	}

	static void dfs(int x, int y, int dir) {
		// 범위 밖이거나 벽이라면 종료
		if (x < 0 || x >= n || y < 0 || y >= m || temp[x][y] == 6)
			return;

		// 빈칸이라면 감시할 수 있음
		if (temp[x][y] == 0) {
			temp[x][y] = -1;
			tempCnt--;
		}

		// 다음 칸으로 넘어가기 (이미 cctv가 감시했던, cctv가 있는 지역이던 그냥 넘어가면 된다.)
		dfs(x + dx[dir], y + dy[dir], dir);
	}
}
