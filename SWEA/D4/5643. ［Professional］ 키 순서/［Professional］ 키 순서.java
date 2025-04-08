import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	static int n, m;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());

			// 자신보다 작은 것들 저장하는 변수
			ArrayList<Integer>[] smaller = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				smaller[i] = new ArrayList<>();
			}

			// 자신보다 큰 것들 저장하는 변수
			ArrayList<Integer>[] bigger = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				bigger[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				bigger[from].add(to);
				smaller[to].add(from);
			}

			visited = new boolean[n + 1];
			int result = 0;
			for (int i = 1; i <= n; i++) {
				Arrays.fill(visited, false);
				int biggerCount = dfs(i, bigger) - 1;
				
				Arrays.fill(visited, false);
				int smallerCount = dfs(i, smaller) - 1;
				
				if(biggerCount + smallerCount == n - 1) 
					result++;
			}

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int idx, ArrayList<Integer>[] key) {
		int cnt = 1;
		visited[idx] = true;

		for (int next : key[idx]) {
			if (!visited[next]) {
				cnt += dfs(next, key);
			}
		}

		return cnt;
	}
}