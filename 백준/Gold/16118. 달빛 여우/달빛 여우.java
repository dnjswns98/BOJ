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
		long dist;
		int speed; // 이전에 두 배 속도로 달렸는지

		public Node(int v, long dist) {
			this.v = v;
			this.dist = dist;
		}

		public Node(int v, long dist, int speed) {
			this.v = v;
			this.dist = dist;
			this.speed = speed;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken()) * 2; // 늑대의 속도 계산을 위해 거리 * 2
			list[from].add(new Node(to, dist));
			list[to].add(new Node(from, dist));
		}

		// 여우의 최단거리 구하기
		long[] minFoxDist = new long[n + 1];
		Arrays.fill(minFoxDist, Long.MAX_VALUE);
		minFoxDist[1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		int cnt = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
            
            if (cur.dist > minFoxDist[cur.v]) continue;
			
			for (Node next : list[cur.v]) {
				if (minFoxDist[next.v] > cur.dist + next.dist) {
					minFoxDist[next.v] = cur.dist + next.dist;
					pq.add(new Node(next.v, minFoxDist[next.v]));
				}
			}
		}

		// 늑대의 최단거리 구하기
		long[][] minWolfDist = new long[2][n + 1]; // 빠르게 달리기/느리게달리기
		Arrays.fill(minWolfDist[0], Long.MAX_VALUE);
		Arrays.fill(minWolfDist[1], Long.MAX_VALUE);
		// 늑대는 첫 출발을 무조건 빠른 속도로 가야하니 출발지에는 느린 속도로 도착한 것으로 해야함
		minWolfDist[1][1] = 0; // 이전 속도 : 느림, 빠른 속도로 출발해야함

		pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0, 1)); // 첫 이동은 빠르게
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
            
            if (cur.dist > minWolfDist[cur.speed][cur.v]) continue;

			for (Node next : list[cur.v]) {
				long dist = cur.speed == 1 ? next.dist / 2 : next.dist * 2; // 빠르게 이동하면 거리 절반, 느리면 두 배

				if (minWolfDist[1 - cur.speed][next.v] > cur.dist + dist) {
					minWolfDist[1 - cur.speed][next.v] = cur.dist + dist;
					pq.add(new Node(next.v, minWolfDist[1 - cur.speed][next.v], 1 - cur.speed));
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			long min = Math.min(minWolfDist[0][i], minWolfDist[1][i]);
			if (min > minFoxDist[i])
				result++;
		}

		System.out.println(result);
	}
}
