import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static boolean[] isPositive;
	static double min;
	static Point[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int test = 0; test<t; test++) {
			n = Integer.parseInt(br.readLine());
			
			p = new Point[n];
			for(int i = 0; i<n; i++) {
				p[i] = new Point();
				st = new StringTokenizer(br.readLine());
				p[i].x = Integer.parseInt(st.nextToken());
				p[i].y = Integer.parseInt(st.nextToken());
			}
			
			isPositive = new boolean[n];
			min = Double.MAX_VALUE;
			comb(0, 0);
			sb.append(min).append('\n');
		}
		System.out.println(sb);
	}
	
	static void comb(int idx, int cnt) {
		if(idx == n) return;
		
		if(cnt == n/2) {
			min = Math.min(min, solve());
			return;
		}
		
		for(int i = idx; i<n; i++) {
			isPositive[i] = true;
			comb(i + 1, cnt + 1);
			isPositive[i] = false;
		}
	}
	
	static double solve() {
		int xSum = 0;
		int ySum = 0;
		for(int i = 0; i<n; i++) {
			if(isPositive[i]) {
				xSum += p[i].x;
				ySum += p[i].y;
			}
			else {
				xSum -= p[i].x;
				ySum -= p[i].y;
			}
		}
		
		return Math.sqrt(Math.pow(xSum, 2) + Math.pow(ySum, 2));
	}
}
