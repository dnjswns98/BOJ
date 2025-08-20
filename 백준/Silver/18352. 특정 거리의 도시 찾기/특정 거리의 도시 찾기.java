import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(x);
		
		final int INF = Integer.MAX_VALUE;
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, INF);
		minDist[x] = 0;
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			for(int to : list[cur]) {
				if(minDist[to] > minDist[cur] + 1) {
					minDist[to] = minDist[cur] + 1;
					pq.add(to);
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			if(minDist[i] == k) {
				result.add(i);
			}
		}
		
		if(result.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(result);
		for(int v : result) {
			sb.append(v).append('\n');
		}
		System.out.println(sb);
	}
}
