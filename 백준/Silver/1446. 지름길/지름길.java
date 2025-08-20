import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int to;
		int w;

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] list = new ArrayList[d + 1];
		for (int i = 0; i <= d; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 도로 길이를 벗어난 지름길은 무시
		    if (to > d || from > d) continue;
			
			list[from].add(new Node(to, w));
		}

		int INF = Integer.MAX_VALUE;
		int[] minDist = new int[d + 1];
		Arrays.fill(minDist, INF);
		minDist[0] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.to >= d) break;

			if (minDist[cur.to + 1] > minDist[cur.to] + 1) {
				minDist[cur.to + 1] = minDist[cur.to] + 1;
				pq.add(new Node(cur.to + 1, cur.w + 1));
			}
			for (Node next : list[cur.to]) {
				if (minDist[next.to] > minDist[cur.to] + next.w) {
					minDist[next.to] = minDist[cur.to] + next.w;
					pq.add(new Node(next.to, minDist[next.to]));
				}
			}
		}

		System.out.println(minDist[d]);
	}
}
