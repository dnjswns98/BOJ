import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int r1, r2, c1, c2, max;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		arr = new int[r2 - r1 + 1][c2 - c1 + 1];

		max = 0;
		fill();
		
		int maxLen = (int) Math.log10(max);
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				int len = maxLen - (int) Math.log10(arr[i][j]);
				while(len > 0) {
					len--;
					System.out.print(" ");
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void fill() {
		int dir = 0, x = 0, y = 0;
		int cnt = 0;
		int num = 1;
		int dnum = 1;
		while (!isFinished()) {
			if(r1 <= x && x <= r2 && c1 <= y && y <= c2) {
				arr[x - r1][y - c1] = num;
			}
			cnt++;
			num++;
			
			x += dx[dir];
			y += dy[dir];
			
			if(cnt == dnum) {
				cnt = 0;
				if(dir == 1 || dir == 3) dnum++;
				dir = (dir + 1) % 4;
			}
		}
		
		max = num - 1;
	}
	
	static boolean isFinished() {
		return arr[0][0] != 0 && arr[r2 - r1][0] != 0 && arr[0][c2 - c1] != 0 && arr[r2 - r1][c2 - c1] != 0;
	}
}
