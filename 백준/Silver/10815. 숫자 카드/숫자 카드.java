import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			int k = Integer.parseInt(st.nextToken());
			
			sb.append(binarySearch(k, 0, n - 1)).append(' ');
		}
		System.out.println(sb);
	}
	
	static int binarySearch(int key, int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] == key) {
				return 1;
			}
			else if(arr[mid] < key) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return 0;
	}
}
