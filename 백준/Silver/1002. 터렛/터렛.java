import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 원점에서의 목표까지의 거리가 나오므로
// 목표는 원점을 중심으로 반지름이 목표까지의 거리인 원 형태이다.

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			// 두 원점 사이의 거리
			int d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			
			int cnt = 0;

			// 동심원이고 반지름이 같다면
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				cnt = -1;
			} 
			// 두 원이 떨어져있고 외접하지 않는다면 (겹치는 부분이 없는 경우)
			// 두 원의 반지름 합보다 두 원점의 거리가 더 먼 경우임
			else if (d > Math.pow(r1 + r2, 2)) {
				cnt = 0;
			}
			// 두 원이 떨어져있으나 외접함
			else if(d == Math.pow(r1 + r2, 2)) {
				cnt = 1;
			}
			// 내접
			else if(d == Math.pow(r1 - r2, 2)) {
				cnt = 1;
			}
			else if(d < Math.pow(r1 - r2, 2)) {
				cnt = 0;
			}
			else {
				cnt = 2;
			}
			
			System.out.println(cnt);
		}
	}

}
