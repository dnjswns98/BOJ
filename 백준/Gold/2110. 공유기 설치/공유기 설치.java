import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int n, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr[n - 1];
		System.out.println(binarySearch(left, right));
	}
	
	static int binarySearch(int left, int right) {
		int max = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(isValid(mid)) {
				max = Math.max(max, mid);
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return max;
	}
	
	static boolean isValid(int mid) {
		int start = arr[0];
		int cnt = 1;
		for(int i = 1; i<n; i++) {
			if(arr[i] - start >= mid) {
				cnt++;
				start = arr[i];
			}
			if(cnt >= c) return true;
		}
		
		return false;
	}
}
