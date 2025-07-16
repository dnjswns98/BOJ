import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		long z = (100 * m) / n;
		
		if(z >= 99) {
			System.out.println(-1);
			return;
		}
		
		long left = 1;
		long right = n;
		long ans = 0;
		while(left <= right) {
			long mid = (left + right) / 2;
			
			long a = n + mid;
			long b = m + mid;
			
			long c = (100 * b) / a;
			
			if(c > z) {
				ans = mid;
				right = mid - 1;
			}
			else left = mid + 1;
		}

		System.out.println(ans);
	}
}
