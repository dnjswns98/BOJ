import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;

	static class Node implements Comparable<Node> {
		int v;
		int w;
		Node next;

		public Node(int v, int w, Node next) {
			this.v = v;
			this.w = w;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		Node[] node = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node[from] = new Node(to, w, node[from]);
		}

		// 시작 정점으로 가는 임시 노드 추가
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0, null));

		// 최소값 초기화
		int INF = Integer.MAX_VALUE;
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if(minDist[cur.v] < cur.w) continue;

			for (Node temp = node[cur.v]; temp != null; temp = temp.next) {
				if (minDist[temp.v] > temp.w + minDist[cur.v]) {
					minDist[temp.v] = temp.w + minDist[cur.v];
					pq.offer(new Node(temp.v, minDist[temp.v], null));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(minDist[i] == INF ? "INF" : minDist[i]).append("\n");
		}
		System.out.println(sb);
	}
}
