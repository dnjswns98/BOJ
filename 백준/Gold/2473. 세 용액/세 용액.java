import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		boolean isPositive = false;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > 0) isPositive = true;
		}
		Arrays.sort(arr);
//		for (int i = 0; i < n; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();

		long[] ans = new long[3];
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					ans[0] = arr[i];
					ans[1] = arr[left];
					ans[2] = arr[right];
				}

				if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		Arrays.sort(ans);
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}
