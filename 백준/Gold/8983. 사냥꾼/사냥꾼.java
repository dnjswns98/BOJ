import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int n, m, l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		ArrayList<Point> point = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(b > l) continue;
			
			point.add(new Point(a, b));
		}
		
		int cnt = 0;
		for(Point p : point) {
			int left = 0;
			int right = n - 1;
			while(left <= right) {
				int mid = (left + right) / 2;
				
				int dis = Math.abs(arr[mid] - p.x) + p.y;
				
				if(dis <= l) {
					cnt++;
					break;
				}
				
				if(arr[mid] < p.x) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
