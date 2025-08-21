import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;
	static int n, m, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		for(int i = 1; i<=n; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int[] cost = new int[n + 1];
		for(int i = 1; i<=n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int[] minCost = new int[n + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		
		for(int i = 1; i<=n; i++) {
			int root = find(i);
			minCost[root] = Math.min(minCost[root], cost[i]);
		}
		
		int result = 0;
		for(int i = 1; i<=n; i++) {
			if(minCost[i] != Integer.MAX_VALUE) {
				result += minCost[i];
			}
		}
		
		if(result > k) System.out.println("Oh no");
		else System.out.println(result);
	}
	
	static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
}
