import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 1; test <= t; test++) {
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int result = 0;
			int n = (int) Math.pow(2, k);
			
			Queue<Integer> q = new ArrayDeque<>(); 
			for(int i = 0; i<n; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while(!q.isEmpty()) {
				int a = q.poll();
				int b = q.poll();
				
				if(a < b) {
					int temp = a;
					a = b;
					b = temp;
				}
				
				result += a - b;
				
				if(q.isEmpty()) break;
				
				q.offer(a);
			}
			
			System.out.println("#" + test + " " + result);
		}
	}
}