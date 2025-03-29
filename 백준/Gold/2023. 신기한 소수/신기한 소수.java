import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[] first = { 2, 3, 5, 7 }; // 1자리에 올 수 있는 수
	static int[] elseNum = { 1, 3, 7, 9 }; // 나머지 자리에 올 수 있는 수
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < 4; i++) {
			dfs(1, first[i]);
		}

		System.out.println(sb);
	}

	static void dfs(int cnt, int num) { // 현재 자리수, 숫자
		if (cnt == n) {
			sb.append(num).append('\n');
			return;
		}

		for (int i = 0; i < 4; i++) {
			int next = num * 10 + elseNum[i];
			if(check(next))
				dfs(cnt + 1, num * 10 + elseNum[i]);
		}

	}

	static boolean check(int num) { // 소수 판별
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}