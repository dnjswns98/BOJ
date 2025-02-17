import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());;
		int k = Integer.parseInt(st.nextToken());;
		int c = Integer.parseInt(st.nextToken());;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 1;
		int[] cnt = new int[d+1];
		cnt[c] = 1;
		int end = 0;
		while(end < k) {
			if(cnt[arr[end]] == 0) {
				max++;
			}
			cnt[arr[end++]]++;
		}
		
		int count = max;
		int start = 0;
		while(true) {
			if(start == n) {
				break;
			}
			if(end == n)
				end = 0;
			
			if(cnt[arr[start]] == 1) {
				count--;
			}
			cnt[arr[start]]--;
			
			if(cnt[arr[end]] == 0) {
				count++;
			}
			cnt[arr[end]]++;
			
			max = Math.max(max, count);
			start++;
			end++;
		}
		
		
		System.out.println(max);
	}
}
