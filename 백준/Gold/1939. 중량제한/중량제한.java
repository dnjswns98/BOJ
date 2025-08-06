import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] check;
	static ArrayList<node>[] list;
	
	static class node {
		int to;
		int w;
		
		public node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<node>();
		}
		
		int left = 1;
		int right = 0;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			right = Math.max(w, right);
			
			list[from].add(new node(to, w));
			list[to].add(new node(from, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			check = new boolean[n + 1];
			if(dfs(x, y, mid)) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
	
	static boolean dfs(int from, int to, int limit) {
		if(from == to) return true;

		check[from] = true;
		
		for(node next : list[from]) {
			if(!check[next.to] && next.w >= limit) {
				if(dfs(next.to, to, limit)) return true;
			}
		}
		return false;
	}
}
