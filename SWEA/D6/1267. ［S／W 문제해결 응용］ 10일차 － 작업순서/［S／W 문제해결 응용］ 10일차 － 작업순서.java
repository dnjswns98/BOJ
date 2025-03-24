import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] list = new ArrayList[n + 1];
			for(int i = 1; i<=n; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			int[] inDegree = new int[n + 1];
			for(int i = 0; i < m; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				inDegree[to]++;
			}
			
			Deque<Integer> dq = new ArrayDeque<>();
			for(int i = 1; i <= n; i++) {
				if(inDegree[i] == 0)
					dq.add(i);
			}
			
			ArrayList<Integer> result = new ArrayList<>();
			while(!dq.isEmpty()) {
				int from = dq.poll();
				result.add(from);
				
				for(int to : list[from]) {
					inDegree[to]--;
					if(inDegree[to] == 0) {
						dq.add(to);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i : result) {
				sb.append(i + " ");
			}
			System.out.print(sb);
		}
	}
}