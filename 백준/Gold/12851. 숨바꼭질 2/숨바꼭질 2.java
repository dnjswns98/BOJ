import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt, result;
	static boolean[] visited;
	static int[] timeArr;

	static class Node {
		int next;
		int time;

		public Node(int next, int cnt) {
			super();
			this.next = next;
			this.time = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수빈이 위치
		n = Integer.parseInt(st.nextToken());
		// 동생 위치
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[100001]; // 방문 체크
		timeArr = new int[100001]; // 시간 저장
		result = Integer.MAX_VALUE; // 최소횟수
		cnt = 0; // 방법의 개수
		bfs();
		System.out.print(result + "\n" + cnt);
	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(n, 0));
		timeArr[n] = 0; // 시작 위치의 시간 0
		visited[n] = true;

		while (!q.isEmpty()) {
			int current = q.peek().next;
			int time = q.poll().time;

			// 최소값을 찾았다면 더 이상 time을 늘려가면서 찾을 필요가 없다
			if (result < time)
				return;

			if (current == m) {
				cnt++;
				result = time;
			}

			// 이동 가능한 위치 탐색
			int[] num = { current - 1, current + 1, current * 2 };
			for (int next : num) {
				if (next < 0 || next > 100000)
					continue; // 범위 벗어나면 무시

				// 방문하지 않았거나, 같은 시간에 도달한 경우 큐에 추가
				if (!visited[next] || timeArr[next] == time + 1) {
					q.offer(new Node(next, time + 1));
					timeArr[next] = time + 1;
					visited[next] = true;
				}
			}
		}
	}
}
