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
		sorted = new int[n];
		sort();
		sorted = null;
	}
	
	static void sort() {
		// 1 ,2 ,4, 8 ... 이런식으로 크기가 커짐
		for(int size = 1; size < n; size += size) { // size = 부분 리스트의 크기
			for(int l = 0; l < n - size; l += (2 * size)) {
				int mid = l + size;
				int right = Math.min(l + size * 2, n); //배열 인덱스를 넘어가면 안되므로 n값 안으로 지정
				merge(l, mid, right);
			}
		}
	}
	
	static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid;
		int idx = left;
		
		while(l < mid && r < right) {
			if(arr[l] < arr[r]) { //왼쪽값이 더 작은 경우
				sorted[idx++] = arr[l++]; //왼쪽값을 넣고 다음 공간에 할당하기 위해 준비
			}
			else { //오른쪽 값이 더 작은 경우
				sorted[idx++] = arr[r++];
			}
		}
		
		//왼쪽 값이 남았다면
		while(l < mid) {
			sorted[idx++] = arr[l++];
		}
		
		//오른쪽 값이 남았다면
		while(r < right) {
			sorted[idx++] = arr[r++];
		}
		
		//합치기
		for(int i = 0; i<right; i++) {
			arr[i] = sorted[i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //숫자 카드 개수
		
		//숫자 카드 입력
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//mergeSort();
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(upperBound(num) - lowerBound(num)).append(' ');
		}
		
		System.out.println(sb);
	}

	static int lowerBound(int key) {
		int start = 0;
		int end = n;
		
		// start값과 end값이 같아질 때까지 반복
		// 두 값이 같아진다는 것은 key값보다 같거나 큰 값이 처음으로 나오는 index를 찾은 것. 
		// key값보다 같거나 큰 값이 없다면 start값이 n이됨.
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] < key) { //key값이 중간 값보다 크다면 key값은 오른쪽 분기로 이동
				start = mid + 1;
			}
			else { //key가 중간 값보다 작거나 같다면 왼쪽 분기로 이동
				end = mid;
			}
		}
		
		return start;
	}
	
	static int upperBound(int key) {
		int start = 0;
		int end = n;
		
		// start값과 end값이 같아질 때까지 반복
		// 두 값이 같아진다는 것은 key보다 큰 값이 처음으로 나오는 index를 찾은 것. 
		// key보다 큰 값이 없다면 start값이 n이됨.
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] <= key) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		
		return start;
	}
}
