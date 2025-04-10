import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;
	static boolean isFind;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		isFind = false;
		dfs(0, 0);
	}

	static void dfs(int x, int y) {
		if(isFind) return; // 스도쿠 찾았다면 모두 종료
		
		if (y == 9) { // 현재 행을 모두 채웠다면 다음 행으로
			dfs(x + 1, 0);
			return;
		}

		if (x == 9) { // 모두 채워짐
			isFind = true;
			
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			return;
		}

		if (arr[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {				
				if (isPossible(x, y, i)) {
					arr[x][y] = i;
					dfs(x, y + 1);
				}
			}
			arr[x][y] = 0; // 원
		} else {
			dfs(x, y + 1);
		}
	}

	static boolean isPossible(int x, int y, int num) {
		// 같은 행,열 중복 값 검사
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == num) return false;
			if (arr[i][y] == num) return false;
		}

		// 3 * 3검사
		x = (x / 3) * 3;
		y = (y / 3) * 3;
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (arr[i][j] == num) return false;
			}
		}

		return true;
	}
}