import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int tCnt = Integer.parseInt(st.nextToken());
		if(tCnt == 0) {
			System.out.println(m);
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < tCnt; i++) {
			int x = Integer.parseInt(st.nextToken());
			set.add(x);
		}

		ArrayList<Integer>[] party = new ArrayList[m];
		for(int i = 0; i<m; i++) {
			party[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pCnt = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			party[i].add(a);
			for (int j = 1; j < pCnt; j++) {
				int b = Integer.parseInt(st.nextToken());
				party[i].add(b);
				union(a, b);
			}
		}
		
		HashSet<Integer> truth = new HashSet<Integer>();
		for(int p : set) {
			truth.add(find(p));
		}

		int cnt = 0;
		for(int i = 0; i<m; i++) {
			boolean check = false;
			for(int a : party[i]) {
				if(truth.contains(find(a))) {
					check = true;
					break;
				}
			}
			
			if(!check) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)	return;

		parents[bRoot] = aRoot;
	}
}
