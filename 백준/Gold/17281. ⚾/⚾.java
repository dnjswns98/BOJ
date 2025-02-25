import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[] lineUp; // 타순
	static boolean[] isSelected; // 현재 타순이 선
	static int n, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		lineUp = new int[9];
		isSelected = new boolean[9];
		arr = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isSelected[0] = true; // 1번은 4번타자로 고정
		lineUp[3] = 0; // 4번타자 = 1번
		max = 0;
		perm(0);

		System.out.println(max);
	}

	static void perm(int cnt) {
		if (cnt == 9) {
			baseball();
			return;
		}

		if (cnt == 3) { // 4번타자는 항상 1번임
			perm(cnt + 1);
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (isSelected[i])
				continue; // i번이 이미 타석에 들어갔다면

			isSelected[i] = true;
			lineUp[cnt] = i;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}

	static void baseball() {
		int score = 0;
		int playerNum = 0;

		for (int i = 0; i < n; i++) { // i번째 이닝
			int outCount = 0;
			boolean[] base = new boolean[3]; // 1루,2루,3루

			while (true) {
				for (int j = playerNum; j < 9; j++) {
					switch (arr[i][lineUp[j]]) {
					case 0:
						outCount++;
						break;

					case 1: // 1루타
						if (base[2]) score++;  // 3루 주자가 홈에 들어옴
						base[2] = base[1]; // 2루 주자가 3루로 이동
						base[1] = base[0]; // 1루 주자가 2루로 이동
						base[0] = true;    // 타자가 1루로 이동
						break;

					case 2: // 2루타
						if (base[2]) score++; // 3루 주자가 홈에 들어옴
						if (base[1]) score++; //2루 주자가 홈에 들어옴
						base[2] = base[0]; // 1루 주자가 3루로 이동
						base[0] = false;
						base[1] = true; // 홈에서 2루로
						break;

					case 3: // 3루타
						for (int k = 2; k >= 0; k--) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						base[2] = true; // 홈에서 3루로
						break;

					case 4:
						for (int k = 2; k >= 0; k--) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++;
						break;
					}

					if (outCount == 3) {
						playerNum = (j + 1) % 9; 
						break;
					}
				}

				if (outCount < 3) {
					playerNum = 0;
				} else
					break;
			}
		}

		if (max < score)
			max = score;
	}
}
