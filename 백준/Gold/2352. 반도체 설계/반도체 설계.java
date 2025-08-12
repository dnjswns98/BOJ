import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(c, 0, size, arr[i]);

			if (pos < 0)
				pos = -(pos + 1);

			c[pos] = arr[i];
			if (pos == size) size++;
		}

		System.out.println(size);
	}
}
