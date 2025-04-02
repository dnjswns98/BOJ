import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, d, k, c;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] cnt = new int[d + 1];
		cnt[c] = 1; // 무료쿠폰
		int count = 1; // 초밥 종류 개수 (무료 쿠폰으로 하나 가지고 시작)
		for(int i = 0; i<k; i++) {
			if(cnt[arr[i]] == 0) count++;
			cnt[arr[i]]++;
		}
		
		// 슬라이딩 윈도우
		int max = count;
		int start = 0;
		int end = k;
		while(start < n) {
			if(end == n) end = 0;
			
			if(cnt[arr[start]] == 1) count--;
			cnt[arr[start]]--;
			
			if(cnt[arr[end]] == 0) count++;
			cnt[arr[end]]++;
			
			max = Math.max(max, count);
			
			start++;
			end++;
		}
		
		System.out.println(max);
	}
}
