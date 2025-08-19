import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		long result = Long.MAX_VALUE;
		long right = arr[n - 1] * m;
		long left = 1;
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long cnt = 0;
			for(int i = 0; i<n; i++) {
				cnt += mid / arr[i];
				
				if(cnt >= m) break;
			}
			
			if(cnt >= m) {
				right = mid - 1;
				result = Math.min(result, mid);
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}
}
