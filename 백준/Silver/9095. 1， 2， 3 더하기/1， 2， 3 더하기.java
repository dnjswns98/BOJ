import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i< t; i++) {
		n = Integer.parseInt(br.readLine());
		
		cnt = 0;
		dfs(0);
		
		System.out.println(cnt);
		}
	}
	
	static void dfs(int sum) {
		if(sum > n) return;
		
		if(sum == n) {
			cnt++;
			return;
		}
		
		for(int i = 1; i<=3; i++) {
			dfs(sum + i);
		}
	}
}
