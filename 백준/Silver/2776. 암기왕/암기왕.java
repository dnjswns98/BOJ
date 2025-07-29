import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> bList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());

				boolean isValid = false;
				int left = 0;
				int right = n - 1;
				while (left <= right) {
					int mid = (left + right) / 2;

					if (a[mid] == num) {
						isValid = true;
						break;
					} else if (a[mid] < num) {
						left = mid + 1;
					} else
						right = mid - 1;
				}

				if (isValid) {
					sb.append(1);
				} else
					sb.append(0);
				sb.append('\n');
			}

			t--;
		}
		System.out.println(sb);
	}
}
