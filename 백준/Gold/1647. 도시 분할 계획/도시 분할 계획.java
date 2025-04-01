import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static ArrayList<Edge> edge;
	static int[] parents;

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 모든 간선 정보 저장
		edge = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edge.add(new Edge(from, to, weight));
		}
		Collections.sort(edge); // 간선의 가중치에 따라 오름차순 정렬

		// 초기화
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		// 모든 집을 하나의 마을로 생각하고 묶은 다음에 가장 가중치가 큰 것을 빼주면 2개의 마을이 생김
		int result = 0;
		int max = 0;
		for (Edge e : edge) {
			if (union(e.from, e.to)) {
				result += e.weight;
				max = Math.max(max, e.weight);
			}
		}
		
		System.out.println(result - max);
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
