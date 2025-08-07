import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test = 0; test < t; test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] a = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<m; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				cnt += n - upperBound(0, n, a, num);
			}
			
			System.out.println(cnt);
		}
	}
	
	static int upperBound(int left, int right, int[] arr, int target) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] <= target) {
				left = mid + 1;
			}
			else right = mid;
		}
		
		return left;
	}
}
