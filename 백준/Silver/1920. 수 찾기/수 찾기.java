import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] sorted;
	
	static void mergeSort() {
		sorted = new int[n]; //임시 배열
		sort(0, n - 1);
		sorted = null;
	}
	
	static void sort(int left, int right) {
		for(int size = 1; size <= right; size += size) { //size = 부분리스트의 크기
			for(int l = 0; l<=right - size; l += (2 * size)) { //왼쪽 부분리스트와 오른쪽 부분리스트 합쳐야함
				int mid = l + size - 1;
				int high = Math.min(l + (2 * size) - 1, right); //배열 인덱스를 넘어갈 수 있음
				merge(l, mid, high);
			}
		}
	}
	
	static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			// 왼쪽 부분 리스트의 원소가 오른쪽 부분리스트의 값보다 작을 경우
			if(arr[l] < arr[r]) {
				sorted[idx++] = arr[l++];
			}
			// 오른쪽이 더 작을 경우
			else {
				sorted[idx++] = arr[r++];
			}
		}
		
		// 왼쪽 부분리스트가 아직 남았다면
		if(l <= mid) {
			while(l <= mid) {
				sorted[idx++] = arr[l++];
			}
		}
		// 오른쪽 부분리스트가 아직 남았다면
		else {
			while(r <= right) {
				sorted[idx++] = arr[r++];
			}
		}
		
		// 정렬된 배열을 기존의 배열에 복사
		for(int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//Arrays.sort(arr);
		mergeSort();
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(num)).append('\n');
		}
		
		System.out.println(sb);
	}

	static char binarySearch(int key) {
		int start = 0;
		int end = n - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == key)
				return '1';
			
			if(arr[mid] < key) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return '0';
	}
}
