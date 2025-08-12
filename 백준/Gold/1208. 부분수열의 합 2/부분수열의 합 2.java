import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> alist = new ArrayList<>();
		ArrayList<Integer> blist = new ArrayList<>();
		
		makeSum(0, n / 2, 0, alist);
		makeSum(n / 2, n, 0, blist);

		Collections.sort(blist);
		
		long result = 0;
		for(int a : alist) {
			int key = m - a;
			
			result += upperBound(blist, key) - lowerBound(blist, key);
		}
		
		if(m == 0) result--;
		
		System.out.println(result);
	}

	static int lowerBound(ArrayList<Integer> list, int key) {
		int left = 0;
		int right = list.size();
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(list.get(mid) < key) {
				left = mid + 1;
			}
			else right = mid;
		}
		return left;
	}

	static int upperBound(ArrayList<Integer> list, int key) {
		int left = 0;
		int right = list.size();
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(list.get(mid) <= key) {
				left = mid + 1;
			}
			else right = mid;
		}
		return left;
	}

	static void makeSum(int start, int end, int sum, ArrayList<Integer> list) {
		if (start == end) {
			list.add(sum);
			return;
		}
		
		makeSum(start + 1, end, sum + arr[start], list);
		makeSum(start + 1, end, sum, list);
	}
}
