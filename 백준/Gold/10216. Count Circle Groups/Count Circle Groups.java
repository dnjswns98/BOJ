import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int x;
		int y;
		int w;
		
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test<t; test++) {
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<Node> list = new ArrayList<>();
			
			parents = new int[n];
			for(int i = 0; i<n; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				list.add(new Node(x,y,w));
			}
			
			for(int i = 0; i<list.size(); i++) {
				Node a = list.get(i);
				for(int j = i + 1; j<list.size(); j++) {
					Node b = list.get(j);
					
					if(find(i) == find(j)) continue;
					
					int r = (int) Math.pow(a.w + b.w, 2);
					int dir = (int) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
					if(r >= dir) {
						union(i, j);
					}
				}
			}
			
			HashSet<Integer> set = new HashSet<>();
			for(int num : parents) {
				set.add(find(num));
			}
			
			sb.append(set.size()).append('\n');
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
