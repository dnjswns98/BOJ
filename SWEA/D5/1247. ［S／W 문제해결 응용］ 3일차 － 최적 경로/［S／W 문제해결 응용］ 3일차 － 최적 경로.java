import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr; // 고객 위치
	static int n; // 크기
	static int cx, cy; // 회사 위치
	static int hx, hy; // 집 위치
	static boolean[] visited;
	static int min; //최소 거리
	static int sum; //모든 거리의 총 합
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= 10; test++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			st = new StringTokenizer(br.readLine());
			
			// 회사 위치 입력
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());

			// 집 위치 입력
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());

			// 고객 위치 입력
			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[n];
			min = Integer.MAX_VALUE;
			sum = 0;
			dfs(cx, cy, 0); // 회사에서 출발, 현재 방문한 고객 수
			
			System.out.println("#" + test + " " + min);
		}
	}

	static void dfs(int x, int y, int cnt) { // x, y = 현재 위치, cnt = 방문한 고객 수
		if(cnt == n) {
			sum += Math.abs(x - hx) + Math.abs(y - hy); //집까지의 거리
			min = Math.min(min, sum);
			sum -= Math.abs(x - hx) + Math.abs(y - hy);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue; // 이미 방문한 곳이라면 다음 탐색
			
			visited[i] = true;
			sum += Math.abs(x - arr[i][0]) + Math.abs(y - arr[i][1]); //현재 위치에서 이동한 거리
			dfs(arr[i][0], arr[i][1], cnt + 1);
			visited[i] = false;
			sum -= (Math.abs(x - arr[i][0]) + Math.abs(y - arr[i][1]));
		}
	}
}