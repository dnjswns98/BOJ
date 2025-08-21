import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents, cnt;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(com == 0) {
				union(a, b);
			}
			else {
				if(find(a) == find(b)) {
					sb.append("yes").append('\n');
				}
				else sb.append("no").append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static void init() {
		parents = new int[n + 1];
		cnt = new int[n + 1];
		for(int i = 0; i<=n; i++) {
			parents[i] = i;
			cnt[i] = 0;
		}
	}
	
	static int find(int a) {
		if(a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		// 원소 갯수가 더 많은 곳에 합치기
		if(cnt[aRoot] < cnt[bRoot]) {
			parents[aRoot] = bRoot;
			cnt[bRoot] += cnt[aRoot];
		}
		else {
			parents[bRoot] = aRoot;
			cnt[aRoot] += cnt[bRoot];
		}
	}
}
