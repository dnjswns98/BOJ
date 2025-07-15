import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		// B[K] = X
		// 조건 1 : X <= K
		int left = 1;
		int right = k;
		int ans = Integer.MAX_VALUE;
		while (left <= right) {
			// 조건 2 : B[K] = X 라는 말은 X값보다 작은 것의 개수가 K개가 있다는 뜻
			int mid = (left + right) / 2;

			// mid가 X 역할
			if (isValid(mid)) {
				// 조건 4 : 답일 가능성이 있는 모든 수 중에 가장 작은 값이 답임
				ans = Math.min(ans, mid);
				right = mid - 1;
			}
			else {
				// 조건 5 : 답일 가능성이 없다면 (X값보다 작은 것의 개수가 K값 보다 작다면) X값을 늘려야함.
				left = mid + 1;
			}
		}
		
		System.out.println(ans);
	}

	static boolean isValid(int mid) {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			// 조건 3 : X값보다 작은 것의 개수가 K값보다 크다면 답일 가능성이 있음
			// 행렬이므로 1행은 1의 구구단, 2행은 2의 구구단
			cnt += Math.min(n, mid / i);
		}
		
		if(cnt >= k) {
			return true;
		}
		return false;
	}
}
