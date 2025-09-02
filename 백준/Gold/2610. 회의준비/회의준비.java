import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parents;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		parents = new int[n + 1];
		for(int i = 1; i<=n; i++) {
			parents[i] = i;
		}
		
		int[][] dist = new int[n + 1][n + 1];
		for(int i = 1; i<=n; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b] = dist[b][a] = 1;
			union(a, b);
		}
		
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 1; i<=n; i++) {
			int root = find(i);
			map.putIfAbsent(root, new ArrayList<>());
			map.get(root).add(i);
		}

		ArrayList<Integer> result = new ArrayList<>();
		for(ArrayList<Integer> group : map.values()) {
			int bestIdx = 0;
			int bestDist = INF;
			
			for(int a : group) {
				int max = 0;
				for(int b : group) {
					max = Math.max(max, dist[a][b]);
				}
				
				if(max < bestDist) {
					bestDist = max;
					bestIdx = a;
				}
			}
			
			result.add(bestIdx);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append('\n');
		Collections.sort(result);
		for(int v : result) {
			sb.append(v).append('\n');
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
		
		if(aRoot == bRoot) return;
		
		parents[aRoot] = bRoot;
	}
}
