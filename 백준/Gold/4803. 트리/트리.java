import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	static boolean[] isTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 0;
		while (true) {
			t++;
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if(n == 0 && m == 0) break;
			
			parents = new int[n + 1];
			isTree = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
				isTree[i] = true;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}

			HashSet<Integer> set = new HashSet<>();
			for(int i = 1; i<=n; i++) {
				if(isTree[find(i)]) {
					set.add(find(i));
				}
			}
			
			int cnt = set.size();
			
			sb.append("Case ").append(t).append(": ");
			if(cnt > 1) {
				sb.append("A forest of ").append(cnt).append(" trees.");
			}
			else if(cnt == 1) {
				sb.append("There is one tree.");
			}
			else {
				sb.append("No trees.");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			isTree[bRoot] = false;
			return;
		}
		
		parents[aRoot] = bRoot;
		isTree[bRoot] = isTree[aRoot] && isTree[bRoot];
	}
}
