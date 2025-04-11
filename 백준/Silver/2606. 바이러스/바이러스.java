import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		int cnt = 0;
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			cnt++;
			
			for(int next : list[cur]) {
				if(visited[next]) continue;
				visited[next] = true;
				dq.add(next);
			}
		}
		
		System.out.println(cnt - 1);
	}
}