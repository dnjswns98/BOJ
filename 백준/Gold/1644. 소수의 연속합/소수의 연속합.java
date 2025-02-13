import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[n + 1]; //소수인지 체크하는 변수, false가 소수
		for(int i = 2; i*i<=n; i++) {
			if(arr[i] == true) continue;
			for(int j = i+i; j<=n; j+=i) {
				arr[j] = true;
			}
		}
		
		List<Integer> prime = new ArrayList<>(); //소수만 저장하는 변수
		for(int i = 2; i<=n; i++) {
			if(arr[i] == false) {
				prime.add(i);
			}
		}
		
		int size = prime.size();
		int left = 0;
		int right = 0;
		int sum = 0;
		int result = 0;
		while(true) {
			if(left == size && right == size){
				break;
			}
			
			if(sum == n) {
				result++;
				sum -= prime.get(left++);
			}
			else if(sum < n && right < size) {
				sum += prime.get(right++);
			}
			else if(sum > n || left == size - 1) {
				sum -= prime.get(left++);
			}
		}

		System.out.println(result);
	}
}
