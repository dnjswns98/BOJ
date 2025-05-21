import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test <= t; test++) {
			int max = 0;
			int min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<10; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				int sum = 0;
				while(num != 0) {
					sum += num % 10;
					num/=10;
				}
				
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			
			System.out.println("#" + test + " " + max + " " + min);
		}
	}
}