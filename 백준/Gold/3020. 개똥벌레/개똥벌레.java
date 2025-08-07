import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				aList.add(num);
			} else {
				bList.add(num);
			}
		}
		Collections.sort(aList);
		Collections.sort(bList);

		int min = n;
		int cnt = 0;
		for(int i = 1; i<=m; i++) {
			int crash = aList.size() - lowerBound(aList, i);
			crash += bList.size() - lowerBound(bList, m - i + 1);
			
			if(crash < min) {
				min = crash;
				cnt = 1;
			}
			else if(crash == min) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
	}

	static int lowerBound(ArrayList<Integer> list, int target) {
		int left = 0;
		int right = list.size();
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(list.get(mid) < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		
		return right;
	}
}
