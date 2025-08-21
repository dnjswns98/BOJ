import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
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
		k = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 역으로 면접장이 있는 곳에서 다익스트라 돌리기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[to].add(new Node(from, w));
		}
		
		long INF = Long.MAX_VALUE;
		long[] minDist = new long[n + 1];
		Arrays.fill(minDist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int idx = Integer.parseInt(st.nextToken());
			minDist[idx] = 0;
			pq.offer(new Node(idx, 0));
		}

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (minDist[cur.v] < cur.w) continue;

			for (Node next : list[cur.v]) {
				if (minDist[next.v] > minDist[cur.v] + next.w) {
					minDist[next.v] = minDist[cur.v] + next.w;
					pq.offer(new Node(next.v, minDist[next.v]));
				}
			}
		}

		long maxDist = 0;
		int idx = n;
		for (int i = 1; i <= n; i++) {
			if(maxDist < minDist[i]) {
				maxDist = minDist[i];
				idx = i;
			}
			else if(maxDist == minDist[i]) {
				if(idx > i) {
					idx = i;
				}
			}
		}
		
		System.out.println(idx);
		System.out.println(maxDist);
	}
}
