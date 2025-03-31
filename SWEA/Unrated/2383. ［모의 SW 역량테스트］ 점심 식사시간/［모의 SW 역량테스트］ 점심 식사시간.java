import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int n, min;
	static int[][] arr;
	static List<Point> people;
	static Stair[] stair = new Stair[2];
	static boolean[] visited;

	static class Stair {
		int x;
		int y;
		int w;

		public Stair(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());

			arr = new int[n][n];
			people = new ArrayList<>();
			int stairIdx = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						people.add(new Point(i, j));
					} else if (arr[i][j] > 1) {
						stair[stairIdx++] = new Stair(i, j, arr[i][j]);
					}
				}
			}

			min = Integer.MAX_VALUE;
			visited = new boolean[people.size()];
			dfs(0);

			System.out.println("#" + t + " " + min);
		}
	}

	static void dfs(int cnt) {
		if (cnt == people.size()) {
			List<Integer> aDist = new ArrayList<>(); // a계단을 이용하는 사람들의 거리
			List<Integer> bDist = new ArrayList<>(); // b계단을 이용하는 사람들의 거리
			for (int i = 0; i < cnt; i++) {
				if (visited[i]) {
					int dist = Math.abs(people.get(i).x - stair[0].x) + Math.abs(people.get(i).y - stair[0].y);
					aDist.add(dist);
				} else {
					int dist = Math.abs(people.get(i).x - stair[1].x) + Math.abs(people.get(i).y - stair[1].y);
					bDist.add(dist);
				}
			}
			Collections.sort(aDist); // 거리순으로 오름차순 정렬
			Collections.sort(bDist);
			min = Math.min(min, cal(aDist, bDist));

			return;
		}

		visited[cnt] = true; // a계단 이용하는 경우
		dfs(cnt + 1);
		visited[cnt] = false; // b계단 이용하는 경우
		dfs(cnt + 1);
	}

	static int cal(List<Integer> aDist, List<Integer> bDist) {
		int aTime = 0;
		int bTime = 0;
		int aSize = aDist.size();
		int bSize = bDist.size();

		// 계단을 이용하는 사람들이 모두 내려가는 시간 : 제일 마지막에 내려오는 사람의 시간을 보면 됨
		for (int i = 0; i < aSize; i++) {
			if (i < 3) {
				aTime = aDist.get(aSize - 1) + stair[0].w + 1;
			}
			else {
				if (aDist.get(i - 3) + stair[0].w <= aDist.get(i)) {
					aTime = aDist.get(i) + stair[0].w + 1;
				} else {
					aTime = aDist.get(i - 3) + stair[0].w + 1 + stair[0].w;
				}
			}
		}

		// b계단 이용하는 사람들이 모두 내려가는 시간
		for (int i = 0; i < bSize; i++) {
			if (i < 3) {
				bTime = bDist.get(bSize - 1) + stair[1].w + 1;
			}
			else {
				if (bDist.get(i - 3) + stair[1].w <= bDist.get(i)) {
					bTime = bDist.get(i) + stair[1].w + 1;
				} else {
					bTime = bDist.get(i - 3) + stair[1].w + 1 + stair[1].w;
				}
			}
		}

		return Math.max(aTime, bTime);
	}

}