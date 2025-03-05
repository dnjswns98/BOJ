import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 색종이 개수

		// 색종이 위치 입력
		int[][] arr = new int[100][100];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 색종이가 있는 곳을 1로 채우기
			for (int r = x; r < x + 10; r++) {
				for (int c = y; c < y + 10; c++) {
					arr[r][c] = 1;
				}
			}
		}
		
		int[] dx = {-1,1,0,0}; //상하좌우
		int[] dy = {0,0,-1,1};
		
		//경계면 찾기
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for(int j = 0; j<100; j++) {
				if(arr[i][j] == 1) { //색종이부분이라면
					for(int k = 0; k<4; k++) { //4방향 탐색
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(isValid(nx,ny) && arr[nx][ny] == 0) //인접 값에 0이 있다면 경계면임
							cnt++;
						
						if(!isValid(nx,ny)) //도화지 끝에 있다면
							cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static boolean isValid(int x, int y) {
		if(x >= 0 && x < 100 && y >= 0 && y < 100)
			return true;
		return false;
	}
}
