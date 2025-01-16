import java.util.*;

class Solution {
	static class node {
		int x;
		int y;
		int time;
		public node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int n;
	static int[][] arr;
	static int a,b,c,d;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int result = -1;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			arr = new int[n][n];
			visited = new boolean[n][n];
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			
			result = -1;
			bfs(a, b);
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			node p = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int time = p.time;
				
				if(nx == c && ny == d) {
					result = time + 1;
					return;
				}
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 1 || visited[nx][ny])
					continue;
				
				if(arr[nx][ny] == 0) { //빈 공간
					visited[nx][ny] = true;
					q.add(new node(nx,ny,time + 1));
				}
				else if(arr[nx][ny] == 2) { //소용돌이
					if(time % 3 == 0) {
						q.add(new node(p.x, p.y, time + 1));
					}
					else if(time % 3 == 1) {
						q.add(new node(p.x, p.y, time + 1));
					}
					else if(time % 3 == 2) {
						visited[nx][ny] = true;
						q.add(new node(nx,ny,time + 1));
					}
				}
			}
		}
	}
}