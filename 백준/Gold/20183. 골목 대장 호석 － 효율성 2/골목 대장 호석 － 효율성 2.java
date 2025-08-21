import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, a, b;
	static long c;
	static long[] minDist;
	static final long INF = Long.MAX_VALUE;
	static ArrayList<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int v;
		long w;
		
		public Node(int v, long w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Long.parseLong(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		int left = 1;
		int right = 0;
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, w));
			list[to].add(new Node(from, w));
			right = Math.max(right, w);
		}
		
		minDist = new long[n + 1];
		System.out.println(binarySearch(left, right));
	}

	static int binarySearch(int left, int right) {
		int result = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(dijkstra(mid)) {
				right = mid - 1;
				result = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		return result;
	}
	
	static boolean dijkstra(int limit) {
		Arrays.fill(minDist, INF);
		minDist[a] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(a, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			if(minDist[cur.v] < cur.w) continue;
			
			for(Node next : list[cur.v]) {
				if(next.w > limit) continue;
				if(minDist[next.v] > cur.w + next.w) {
					minDist[next.v] = cur.w + next.w;
					pq.offer(new Node(next.v, minDist[next.v]));
				}
			}
		}
		
		return minDist[b] <= c;
	}
}
