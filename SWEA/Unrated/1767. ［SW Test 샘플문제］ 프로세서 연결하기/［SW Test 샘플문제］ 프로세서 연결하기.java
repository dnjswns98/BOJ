import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n; // 멕시노스 크기
	static int[][] arr;
	static int minWire; // 전선 수
	static int maxCore; // 코어 수
	static List<Point> list; // 가장자리를 제외한 코어 위치 담을 리스트
	static int listSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); // 멕시노스 입력
					if (arr[i][j] == 1) { // 코어라면
						if (i > 0 && i < n - 1 && j > 0 && j < n - 1) // 가장자리가 아니라면 리스트 추가
							list.add(new Point(i, j));
					}
				}
			}

			minWire = Integer.MAX_VALUE;
			maxCore = 0;
			dfs(0, 0, 0);
			
			System.out.println("#" + test + " " + minWire);
		}
	}

	static void dfs(int idx, int wire, int core) {
		if (idx == list.size()) { // 모든 코어를 탐색했다면
			if (maxCore < core) { // 최대 코어 수 갱신
				maxCore = core;
				minWire = wire;
			} else if (maxCore == core) { // 코어수가 같다면
				minWire = Math.min(wire, minWire); // 최소 전선 수 갱신
			}
			return;
		}

		int x = list.get(idx).x;
		int y = list.get(idx).y;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int wireCnt = 0;

			while (true) {
				// 범위를 벗어난다는 것은 전선이 아무 장애물 없이 도달했다는 것
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
					break;
				}

				if (arr[nx][ny] == 1) { // 가는 도중에 코어, 전선을 만나면
					wireCnt = 0;
					break;
				}

				wireCnt++;
				nx += dx[i];
				ny += dy[i];
			}

			if (wireCnt == 0) { // 전선을 깔지 못하는 경우
				dfs(idx + 1, wire, core);
				continue;
			}

			// 전선 깔기
			for (int j = 1; j <= wireCnt; j++) {
				nx = x + dx[i] * j;
				ny = y + dy[i] * j;
				arr[nx][ny] = 1;
			}
			dfs(idx + 1, wire + wireCnt, core + 1);
			
			//다른 방향 탐색을 위해 초기화
			for (int j = 1; j <= wireCnt; j++) {
				nx = x + dx[i] * j;
				ny = y + dy[i] * j;
				arr[nx][ny] = 0;
			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}