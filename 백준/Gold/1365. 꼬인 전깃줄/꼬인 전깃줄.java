import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] c = new int[n];
		int size = 0; // LIS 길이
		// arr[i] 값을 순서대로 보면서, 이 값이 c 배열에서 들어갈 수 있는 위치를 찾아 넣고, 그 위치가 현재 LIS의 길이와 같다면 size를 늘려.
		for(int i = 0; i<n; i++) {
			// i원소가 최소값으로 끝에 설 수 있는 위치 찾기
			int pos = upperBound(0, size, arr[i], c);
			c[pos] = arr[i];
			if(pos == size) size++;
		}
		
		System.out.println(n - size);
	}
	
	static int upperBound(int left, int right, int key, int[] c) {
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(c[mid] <= key) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return left;
	}
}