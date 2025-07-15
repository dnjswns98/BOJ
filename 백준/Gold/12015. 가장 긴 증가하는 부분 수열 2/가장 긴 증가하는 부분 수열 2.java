import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] c = new int[n];
		int size = 0;
		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(c, 0, size, arr[i]);	
			if (pos >= 0) continue;

			pos = Math.abs(pos) - 1;
			c[pos] = arr[i];
			if(pos == size) size++;
		}
		
		System.out.println(size);
	}
}
