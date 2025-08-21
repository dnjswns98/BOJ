import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static ArrayList<Node>[] list;
	static final int INF = 1000000000;
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		public Node(int v, int w) {
			super();
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

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(minDist[cur.v] < cur.w) continue;
			
			if(cur.v == end) break;
			
			for(Node next : list[cur.v]) {
				if(minDist[next.v] > minDist[cur.v] + next.w) {
					minDist[next.v] = minDist[cur.v] + next.w;
					pq.offer(new Node(next.v, minDist[next.v]));
				}
			}
		}

		System.out.println(minDist[end]);
	}
}
