import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 }; // 우 하 좌 상
	static int[][] arr; //달팽이 저장
	static int n; //크기
	static int cnt; //숫자넣기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= 10; test++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			cnt = 1;
			snail(0, 0, 0); //row, col, 방향
			
            System.out.println("#" + test);
			for(int i = 0; i<n; i++) { //출력
				for(int j = 0; j<n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	static void snail(int x, int y, int vector) {
		arr[x][y] = cnt++; //현재 좌표 숫자 찍기
		if(cnt == n*n + 1) {
			return;
		}
		
		int nx = x + dx[vector]; //다음에 갈 곳
		int ny = y + dy[vector];
		while(true) {
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
				nx -= dx[vector];
				ny -= dy[vector];
				break;
			}
			
			arr[nx][ny] = cnt++;
			nx += dx[vector];
			ny += dy[vector];
		}
		
		nx += dx[(vector+1)%4];
		ny += dy[(vector+1)%4];
		snail(nx, ny, (vector+1)%4);
	}
}