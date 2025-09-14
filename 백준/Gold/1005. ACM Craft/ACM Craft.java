import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test<t; test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] cost = new int[n + 1];
			for(int i = 1; i<=n; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer>[] aTob = new ArrayList[n + 1];
			for(int i = 1; i<=n; i++) {
				aTob[i] = new ArrayList<Integer>();
			}
			
			int[] indegree = new int[n + 1]; 
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				aTob[a].add(b);
				indegree[b]++;
			}
			
			int target = Integer.parseInt(br.readLine());
			
			int[] result = new int[n + 1];
			Queue<Integer> q = new ArrayDeque<>();
			for(int i = 1; i<=n; i++) {
				result[i] = cost[i];
				
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int next : aTob[cur]) {
					result[next] = Math.max(result[next], cost[next] + result[cur]);
					indegree[next]--;
					
					if(indegree[next] == 0) {
						q.add(next);
					}
				}
			}
			
			System.out.println(result[target]);
		}
	}
}
