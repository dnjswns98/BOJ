import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		for(int i = 0; i<n; i++) {
			visited = new boolean[n];
			if(dfs(i, 1)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	
	static boolean dfs(int idx, int cnt) {
		// 5명이 연결되어 있다면
		if(cnt == 5) {
			return true;
		}
		visited[idx] = true;
		
		for(int i : list[idx]) {
			if(visited[i]) continue;
			
			if(dfs(i, cnt + 1)) { // 5명이 완료되면 return
				return true;
			}
		}
		visited[idx] = false; // 원복
		
		return false;
	}
}
