import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

	static int n, m, c;
	static int[][] arr;
	static int[][] profit;
	
	static class Group implements Comparable<Group>{
		int x;
		int y;
		int cost;
		
		public Group(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Solution.Group o) {
			return Integer.compare(o.cost, this.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 모든 구역의 수익을 계산하기
			PriorityQueue<Group> pq = new PriorityQueue<>();
			profit = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					getProfit(i, j, 0, 0, 0, i, j); // i,j 부터 i,j+m-1 까지의 수익 계산
					pq.add(new Group(i, j, profit[i][j]));
					//System.out.print(profit[i][j] + " ");
				}
			}
			
			sb.append("#").append(t).append(" ");
			
			Group best = pq.poll();
			while(!pq.isEmpty()) {
				Group next = pq.poll();
				
				if(best.x != next.x) { // 행이 다르다면
					sb.append(best.cost + next.cost).append("\n");
					break;
				}
				else { // 행이 같다면 겹치는 열이 있는지 검사해야함
					if(Math.abs(best.y - next.y) >= m) {
						sb.append(best.cost + next.cost).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}

	static void getProfit(int i, int j, int cnt, int honey, int cost, int x, int y) {
		if (honey > c) return;

		if (cnt == m) {
			profit[x][y] = Math.max(profit[x][y], cost);
			return;
		}

		getProfit(i, j + 1, cnt + 1, honey + arr[i][j], cost + arr[i][j] * arr[i][j], x, y); // 선택
		getProfit(i, j + 1, cnt + 1, honey, cost, x, y); // 선택x
	}
}
