import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		arr = new int[k];
		long max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long left = 1;
		long right = max * 2;
		long result = 0;
		while (left < right) {
			long sum = 0;
			long mid = (left + right) / 2;

			for (int num : arr) {
				sum += num / mid;
			}
			
			if(sum < n) {
				right = mid;
			}
			else {
				result = mid;
				left = mid + 1;
			}
			
		}
		
		System.out.println(result);
	}
}
