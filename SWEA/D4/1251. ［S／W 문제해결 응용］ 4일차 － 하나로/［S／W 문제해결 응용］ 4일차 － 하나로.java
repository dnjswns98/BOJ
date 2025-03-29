import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[] parents;

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());

			int[] x = new int[n];
			int[] y = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			double m = Double.parseDouble(br.readLine());

			ArrayList<Edge> edge = new ArrayList<>();
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					long distX = Math.abs(x[i] - x[j]);
					long distY = Math.abs(y[i] - y[j]);
					long dist = distX * distX + distY * distY;
					edge.add(new Edge(i, j, dist));
				}
			}
			Collections.sort(edge);

			int cnt = 0;
			long sum = 0;
			make();
			for (Edge e : edge) {
				if (union(e.from, e.to)) {
					sum += e.weight;

					if (++cnt == n - 1)
						break;
				}
			}

			System.out.println("#" + t + " " + Math.round(sum * m));
		}
	}

	static void make() {
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[aRoot] = bRoot;
		return true;
	}
}