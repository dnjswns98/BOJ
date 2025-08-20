import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<Node>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] route = new int[n + 1];
		route[start] = 0;
		
		int INF = Integer.MAX_VALUE;
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Integer> init = new ArrayList<>();
		init.add(start);
		pq.add(new Node(start, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(minDist[cur.v] < cur.w) continue;
			
			for(Node next: list[cur.v]) {
				if(minDist[next.v] > minDist[cur.v] + next.w) {
					minDist[next.v] = minDist[cur.v] + next.w;
					pq.add(new Node(next.v, minDist[next.v]));
					route[next.v] = cur.v;
				}
			}
		}
		
		ArrayList<Integer> routes = new ArrayList<>();
		int current = end;
		while(current != 0) {
			routes.add(current);
			current = route[current];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(minDist[end]).append('\n');
		sb.append(routes.size()).append('\n');
		for(int i = routes.size() - 1; i >= 0; i--) {
			sb.append(routes.get(i)).append(' ');
		}
		System.out.println(sb);
	}
}
