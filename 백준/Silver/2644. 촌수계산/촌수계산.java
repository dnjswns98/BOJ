import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int a, b, n, m;
	static boolean[] visited;
	static List<Integer>[] list;
	
	static class Node{
		int next;
		int cnt;
		
		public Node(int next, int cnt) {
			super();
			this.next = next;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사람 수
		n = Integer.parseInt(br.readLine());

		// 촌수를 계산해야하는 두 사람의 번호
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		// 관계의 개수
		m = Integer.parseInt(br.readLine());

		// list 객체 
		list = new ArrayList[n + 1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 각 관계 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		visited = new boolean[n + 1];
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(a, 0));
		visited[a] = true; // 시작 위치 방문처리

		while (!q.isEmpty()) {
			int current = q.peek().next;
			int cnt = q.poll().cnt;
			
			for(int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				
				if(visited[next]) continue;
				
				if(next == b) {
					return cnt + 1;
				}
				
				visited[next] = true;
				q.offer(new Node(next, cnt + 1));
			}
		}
		
		return -1;
	}
}
