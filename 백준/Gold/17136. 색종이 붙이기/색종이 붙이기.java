import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static ArrayList<Point> list;
	static boolean[][] visited;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[10][10];
		list = new ArrayList<>();
		for(int i = 0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					list.add(new Point(i, j));
				}
			}
		}
		
		visited = new boolean[10][10];
		result = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void dfs(int idx, int cnt) {
		if(result <= cnt) return; // 최소개수보다 많다면 더 이상 탐색x
		
		if(idx == list.size()) { // 끝까지 탐색했다면
			result = cnt;
			return;
		}
		
		Point cur = list.get(idx);
		
		if(!visited[cur.x][cur.y]) { // 색종이 붙이지 않았다면
			for(int i = 5; i > 0; i--) { // 사이즈가 큰 색종이부터 붙이기
				if(paper[i] > 0 && isPossible(cur.x, cur.y, i)) {
					fill(cur.x, cur.y, i); // 방문 처리
					paper[i]--;
					dfs(idx + 1, cnt + 1);
					fill(cur.x, cur.y, i); // 원복
					paper[i]++;
				}
			}
		}
		else dfs(idx + 1, cnt); // 이미 색종이가 붙여져 있는 칸이라면
	}
	
	static void fill(int x, int y, int size) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				visited[i][j] = !visited[i][j];
			}
		}
	}
	
	static boolean isPossible(int x, int y, int size) {
		if(x + size > 10 || y + size > 10) // 경계 밖이라면
			return false;
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(arr[i][j] == 0 || visited[i][j]) // 0인 칸이거나 겹치는 경우
					return false;
			}
		}
		
		return true;
	}
}