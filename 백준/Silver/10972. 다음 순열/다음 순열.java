import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int[] arr;
	static int n;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(nextPermutation()) {
			for(int i = 0; i<n; i++) {
				sb.append(arr[i]).append(' ');
			}
		}
		else sb.append(-1);
		
		System.out.print(sb);
	}

	static boolean nextPermutation() {
		int i = n - 1;
		while(i > 0 && arr[i - 1] >= arr[i])
			i--;
		
		if(i == 0) 
			return false;
		
		int j = n - 1;
		while(arr[i - 1] >= arr[j])
			j--;
		
		swap(i - 1, j);
		
		int k = n - 1;
		while(i < k)
			swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
