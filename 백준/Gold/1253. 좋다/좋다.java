import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// 투 포인터
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			int left = 0;
			int right = n - 1;
			
			while(left < right) {
				// 자기 자신을 포함해서 더하면 안됨
				if(i == left) {
					left++;
					continue;
				}
				if(i == right) {
					right--;
					continue;
				}
				
				int sum = arr[left] + arr[right];
				
				if(sum == arr[i]) {
					cnt++;
					break;
				}
				else if(sum < arr[i]) {
					left++;
				}
				else right--;
			}
		}
		
		System.out.println(cnt);
	}
}
