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
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = 0;
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			left = Math.max(left, arr[i]);
			right += arr[i];
		}

		int result = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(m >= check(mid)) {
				result = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
	static int check(int limit) {
		int money = limit;
		int cnt = 1;
		for(int i = 0; i<n; i++) {
			money -= arr[i];
			
			if(money < 0) {
				money = limit - arr[i];
				cnt++;
			}
		}
		
		return cnt;
	}
}
