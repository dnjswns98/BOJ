import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String regax = "(100+1+|01)+";
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test<t; test++) {
			String s = br.readLine();
			
			if(s.matches(regax)) {
				sb.append("YES").append('\n');
			}
			else {
				sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}
}
