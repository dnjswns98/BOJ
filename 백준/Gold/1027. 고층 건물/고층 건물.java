import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, solve(i));
		}
		
		System.out.println(max);
	}

	static int solve(int idx) {
		int cnt = 0;
		double slope = 0;

		// 좌측
		for (int i = idx - 1; i >= 0; i--) {
			double temp = (double) (arr[idx] - arr[i]) / (idx - i);
			
			if(idx - 1 == i || temp < slope) {
				cnt++;
				slope = temp;
			}
		}
		
		// 우측
		for(int i = idx + 1; i<n; i++) {
			double temp = (double) (arr[idx] - arr[i]) / (idx - i);
			
			if(idx + 1 == i || temp > slope) {
				cnt++;
				slope = temp;
			}
		}
		
		return cnt;
	}
}
