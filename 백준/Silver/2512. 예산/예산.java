import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		m = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		if(sum <= m) {
			System.out.println(arr[n - 1]);
			return;
		}
		
		int left = 0;
		int right = arr[n - 1];
		int max = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			sum = 0;
			for(int i = 0; i<n; i++) {
				if(arr[i] <= mid) {
					sum += arr[i];
				}
				else {
					sum += mid;
				}
			}
			
			if(sum <= m) {
				max = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(max);
	}
}
