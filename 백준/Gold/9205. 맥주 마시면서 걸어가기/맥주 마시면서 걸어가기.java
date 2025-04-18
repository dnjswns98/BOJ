import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static Point[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());

			p = new Point[n + 2];
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[i] = new Point(x, y);
			}
			
			System.out.println(bfs() ? "happy" : "sad");
		}
	}
	
	static boolean bfs() {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(0);
		boolean[] visited = new boolean[n + 2];
		visited[0] = true;
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			
			if(cur == n + 1) { // 도착
				return true;
			}
			
			for(int i = 0; i < n + 2; i++) {
				if(visited[i]) continue;
				
				if(canMove(p[cur], p[i])) {
					visited[i] = true;
					dq.add(i);
				}
			}
		}
		
		return false;
	}
	
	static boolean canMove(Point a, Point b) {
		if(Math.abs(a.x - b.x) + Math.abs(a.y - b.y) <= 1000) {
			return true;
		}
		return false;
	}
}