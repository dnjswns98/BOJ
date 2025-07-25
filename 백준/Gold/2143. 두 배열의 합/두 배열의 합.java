import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> bList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		// 구간합 구하기
		ArrayList<Integer> aList = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			int sum = 0;
			for(int j = i; j<n; j++) {
				sum += a[j];
				aList.add(sum);
			}
		}
		for(int i = 0; i<m; i++) {
			int sum = 0;
			for(int j = i; j<m; j++) {
				sum += b[j];
				bList.add(sum);
			}
		}
		
		Collections.sort(aList);
		Collections.sort(bList);
		
		long cnt = 0;
		for(int i = 0; i<aList.size(); i++) {
			int key = t - aList.get(i);
			int num1 = lowerBound(key, 0, bList.size());
			int num2 = upperBound(key, 0, bList.size());
			
			cnt += num2 - num1;
		}
		
		System.out.println(cnt);
	}
	
	static int lowerBound(int key, int left, int right) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(bList.get(mid) < key) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		
		return left;
	}
	
	static int upperBound(int key, int left, int right) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(bList.get(mid) <= key) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		
		return left;
	}
}
