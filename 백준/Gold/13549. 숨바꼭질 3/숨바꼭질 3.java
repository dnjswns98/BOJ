import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;

	static class Node implements Comparable<Node> {
		int x;
		int time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(n, 0));
		boolean[] visited = new boolean[100001];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.x]) continue;
			visited[cur.x] = true;

			if (cur.x == m) {
				System.out.println(cur.time);
				break;
			}

			if (cur.x < m) {
				if (cur.x * 2 < 100001 && !visited[cur.x * 2]) {
					pq.add(new Node(cur.x * 2, cur.time));
				}
				if (cur.x + 1 < 100001 && !visited[cur.x + 1]) {
					pq.add(new Node(cur.x + 1, cur.time + 1));
				}
			}
			if (cur.x - 1 >= 0 && !visited[cur.x - 1]) {
				pq.add(new Node(cur.x - 1, cur.time + 1));
			}
		}
	}
}
