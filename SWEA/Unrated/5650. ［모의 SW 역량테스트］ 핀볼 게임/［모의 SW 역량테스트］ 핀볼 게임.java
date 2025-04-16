import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	static int n;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Point>[] warm;

	// 블록 반사 방향 테이블 (blockDir[블록번호][진입방향] = 반사후 방향)
	static int[][] blockDir = { 
			{}, // 0번 블록 없음
			{ 1, 3, 0, 2 }, // 블록 1
			{ 3, 0, 1, 2 }, // 블록 2
			{ 2, 0, 3, 1 }, // 블록 3
			{ 1, 2, 3, 0 }, // 블록 4
			{ 1, 0, 3, 2 }, // 블록 5
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine().trim());

			warm = new ArrayList[11];
			for (int i = 6; i <= 10; i++) {
				warm[i] = new ArrayList<>();
			}

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] >= 6) {
						warm[arr[i][j]].add(new Point(i, j));
					}
				}
			}

			int max = 0;
			// 빈칸(0)에서 4방향으로 출발
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							max = Math.max(max, play(i, j, d));
						}
					}
				}
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static int play(int i, int j, int dir) {
		int cnt = 0;
		int x = i;
		int y = j;

		while (true) {
			x += dx[dir];
			y += dy[dir];

			// 벽에 부딪힘 -> 반사 + 점수 증가
			if (x < 0 || x >= n || y < 0 || y >= n) {
				dir = (dir % 2 == 0) ? dir + 1 : dir - 1; // 반사
				cnt++;
				continue;
			}

			if (arr[x][y] == -1 || (i == x && j == y)) { // 시작점, 블랙홀
				return cnt;
			}

			if (arr[x][y] == 0) { // 현재 방향 유지
				continue;
			}

			// 웜홀을 만난 경우
			if(arr[x][y] >= 6) {
				for(Point p : warm[arr[x][y]]) {
					if(p.x != x || p.y != y) {
						x = p.x;
						y = p.y;
						break;
					}
				}
			}

			// 블록을 만난 경우
			if(1 <= arr[x][y] && arr[x][y] <= 5) {
				dir = blockDir[arr[x][y]][dir];
				cnt++;
			}

		}
	}
}