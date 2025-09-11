import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String k = st.nextToken();
		int kingy = k.charAt(0) - 65 + 1;
		int kingx = k.charAt(1) - '0';

		String s = st.nextToken();
		int stoney = s.charAt(0) - 65 + 1;
		int stonex = s.charAt(1) - '0';

		Map<String, Integer> d = new HashMap<>();
		String[] com = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
		for (int i = 0; i < 8; i++) {
			d.put(com[i], i);
		}

		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			int dir = d.get(str);
			int kx = kingx + dx[dir];
			int ky = kingy + dy[dir];

			if (check(kx, ky)) {
				if (kx == stonex && ky == stoney) {
					int nsx = stonex + dx[dir];
					int nsy = stoney + dy[dir];
					
					if (!check(nsx, nsy)) continue;
					
					stonex = nsx;
					stoney = nsy;
				}
				kingx = kx;
				kingy = ky;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append((char) (kingy + 65 - 1)).append(kingx).append('\n');
		sb.append((char) (stoney + 65 - 1)).append(stonex).append('\n');
		System.out.println(sb);
	}

	static boolean check(int x, int y) {
		if (1 <= x && x <= 8 && 1 <= y && y <= 8)
			return true;
		return false;
	}
}
