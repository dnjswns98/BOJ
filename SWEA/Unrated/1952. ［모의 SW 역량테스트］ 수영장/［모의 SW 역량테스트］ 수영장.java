import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static int min;
	static int[] cost, month;

	static class Point {
		int x;
		int y;
		int dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			cost = new int[4];
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken()); // 이용권 가격
			}

			st = new StringTokenizer(br.readLine());
			month = new int[12];
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken()); // 이용 계획
			}

			min = cost[3]; // 1년 이용권
			dfs(0, 0);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, int sum) {
		if (sum >= min)
			return; // 이미 최소값보다 커졌다면

		if (cnt >= 12) {
			min = sum;
			return;
		}

		if (month[cnt] > 0) { // 해당 월에 사람이 있다면
			dfs(cnt + 1, sum + cost[0] * month[cnt]); // 1일 이용권
			dfs(cnt + 1, sum + cost[1]); // 1달 이용권
			dfs(cnt + 3, sum + cost[2]); // 3달 이용권
		}
		else dfs(cnt + 1, sum);
	}
}