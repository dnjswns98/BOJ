import java.io.*;
import java.util.*;

public class Main {
	static int[][] visited;
	static char[][] c;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		c = new char[n][m];
		for(int i = 0; i<n; i++) {
			c[i] = br.readLine().toCharArray();
		}
	
		result = 0;
		visited = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(visited[i][j] == 0)
					dfs(i,j);
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = 1; // 진행중
		
		int[] dir = getDir(c[x][y]);
		int nx = x + dir[0];
		int ny = y + dir[1];
		
		if(visited[nx][ny] == 0) {
			dfs(nx, ny);
		}
		else if(visited[nx][ny] == 1) { // 진행 중인 곳을 만나면 (사이클)
			result++;
		}

		visited[x][y] = 2;
	}
	
	static int[] getDir(char c) {
		int[] dir = new int[2];
		if(c == 'D') {
			dir[0] = 1;
			dir[1] = 0;
		}
		else if(c == 'L') {
			dir[0] = 0;
			dir[1] = -1;
		}
		else if(c == 'R') {
			dir[0] = 0;
			dir[1] = 1;
		}
		else if(c ==  'U') {
			dir[0] = -1;
			dir[1] = 0;
		}
		return dir;
	}
}
