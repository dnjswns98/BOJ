import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test<t; test++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int diff = b - a;
			int sqrtDiff = (int) Math.sqrt(diff);
			
			if(diff == sqrtDiff * sqrtDiff) {
				sb.append(sqrtDiff * 2 - 1);
			}
			else if(diff <= sqrtDiff * sqrtDiff + sqrtDiff) {
				sb.append(sqrtDiff * 2);
			}
			else sb.append(sqrtDiff * 2 + 1);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
