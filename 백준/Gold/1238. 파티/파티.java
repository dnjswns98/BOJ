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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

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

		int INF = Integer.MAX_VALUE;
		int[][] minDist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(minDist[i], INF);
		}

		for (int i = 1; i <= n; i++) {
			minDist[i][i] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(i, 0));

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if (minDist[i][cur.v] < cur.w)
					continue;

				for (Node next : list[cur.v]) {
					if (minDist[i][next.v] > minDist[i][cur.v] + next.w) {
						minDist[i][next.v] = minDist[i][cur.v] + next.w;
						pq.offer(new Node(next.v, minDist[i][next.v]));
					}
				}
			}
		}
		int max = 0;
		for(int i = 1; i<=n; i++) {
			max = Math.max(max, minDist[i][x] + minDist[x][i]);
		}
		

		System.out.println(max);
	}
}
