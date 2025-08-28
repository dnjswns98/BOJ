import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parents, size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		if(n == 2) {
			System.out.println(1 + " " + 2);
			return;
		}
		
		parents = new int[n + 1];
		size = new int[n + 1];
		for(int i = 1; i<=n; i++) {
			parents[i] = i;
			size[i] = 1;
		}
		
		for(int i = 0; i<n - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			if(size[i] > 0) {
				list.add(i);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.get(0) + " " + list.get(1));
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
		
		if(size[aRoot] < size[bRoot]) {
			parents[aRoot] = bRoot;
			size[bRoot] += size[aRoot];
			size[aRoot] = 0;
		}
		else {
			parents[bRoot] = parents[aRoot];
			size[aRoot] += size[bRoot];
			size[bRoot] = 0;
		}
	}
}
