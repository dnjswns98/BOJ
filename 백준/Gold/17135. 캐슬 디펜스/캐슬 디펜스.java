import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, D, result, max;
	static int[][] arr;
	static int[] archer;
	static ArrayList<Point> list;

	static class monster implements Comparable<monster> {
		int x;
		int y;
		int d;

		public monster(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(monster o) {
			if (this.d == o.d) {
				return this.y - o.y;
			}
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					list.add(new Point(i, j)); // 몬스터 좌표 넣기
				}
			}
		}

		archer = new int[3];
		max = 0;
		comb(0, 0);
		
		System.out.println(max);
	}

	static void comb(int cnt, int start) {
		if (cnt == 3) {
			result = 0;
			attack();
			max = Math.max(result, max);
			return;
		}

		for (int i = start; i < m; i++) {
			archer[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static void attack() {
		HashSet<Point> set = new HashSet<>();
		ArrayList<Point> enemies = new ArrayList<>(list);
		while (!enemies.isEmpty()) {
			
			// 궁수의 범위 내에 있는 모든 경우를 우선순위 큐에 넣기
			for (int y : archer) {
				PriorityQueue<monster> pq = new PriorityQueue<>();
				for (Point p : enemies) {
					int dist = Math.abs(n - p.x) + Math.abs(y - p.y);
					if (dist <= D) {
						pq.add(new monster(p.x, p.y, dist));
					}
				}
				
				// 하나 이상 있다면 가장 가까운 적만 꺼내서 set에 추가
				if(!pq.isEmpty()) {
					monster m = pq.poll();
					set.add(new Point(m.x, m.y));
				}
			}
			
			// 적의 위치를 찾은 후 리스트에서 제거
			for(int i = enemies.size() - 1; i >= 0; i--) {
				for(Point m : set) {
					if(enemies.get(i).x == m.x && enemies.get(i).y == m.y) {
						result++;
						enemies.remove(i);
						set.remove(m);
						break;
					}
				}
			}
			
			// 적 이동
			for(int i = enemies.size() - 1; i >= 0; i--) {
				if(enemies.get(i).x == n - 1) {
					enemies.remove(i);
				}
				else {
					enemies.set(i, new Point(enemies.get(i).x + 1, enemies.get(i).y));
				}
			}
		}
	}
}
