import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] c = new int[n];
		int[] dp = new int[n]; // 각 원소가 몇번째 LIS인지 기록
		int size = 0;
		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(c, 0, size, arr[i]);
			if (pos < 0) pos = -(pos + 1);  // 삽입 위치 계산

			c[pos] = arr[i];
			dp[i] = pos + 1;

			if (pos == size) size++;
		}

		int target = size;
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == target) {
				stack.push(arr[i]);
				target--;
			}
		}

		System.out.println(size);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
