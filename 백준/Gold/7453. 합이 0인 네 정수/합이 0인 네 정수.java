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
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		int[] ab = new int[n * n];
		int[] cd = new int[n * n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ab[i * n + j] = a[i] + b[j];
				cd[i * n + j] = c[i] + d[j];
			}
		}
		Arrays.sort(cd);

		long cnt = 0;
		for (int i = 0; i < n * n; i++) {
			int target = -ab[i];
			int lower = lowerBound(cd, target);
			int upper = upperBound(cd, target);
			cnt += upper - lower;
		}
		
		System.out.println(cnt);
	}

	// target보다 크거나 같은 첫 번째 위치
	static int lowerBound(int[] arr, int target) {
		int left = 0, right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	// target보다 큰 첫 번째 위치
	static int upperBound(int[] arr, int target) {
		int left = 0, right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
