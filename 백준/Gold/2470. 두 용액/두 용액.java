import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = n - 1;
		int min = Integer.MAX_VALUE;
		int[] ans = new int[2];
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				ans[0] = arr[left];
				ans[1] = arr[right];
			}
			
			if(sum < 0) {
				left++;
			}
			else right--;
		}
		
		System.out.println(ans[0] + " " + ans[1]);
	}
}
