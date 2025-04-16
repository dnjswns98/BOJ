import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

	static int n;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());

			list = new ArrayList[6];
			for(int i = 0; i<6; i++) {
				list[i] = new ArrayList<>();
				if (i == 0 || i == 5) {
					for(int j = 0; j<8; j++)
						list[i].add(-1); // 임시 자석
				}
			}
			
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					list[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int magnet = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				boolean dir = (k == 1) ? true : false;

				visited = new boolean[5];
				rotation(magnet, dir);
			}

			int sum = 0;
			for (int i = 1; i <= 4; i++) {
				sum += (list[i].get(0) == 1) ? Math.pow(2, i - 1) : 0;
			}

			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	static void rotation(int magnet, boolean dir) {
		if (magnet == 0 || magnet == 5) return; // 임시 자석

		if (visited[magnet]) return; // 이미 돌린 자석이라면

		visited[magnet] = true;

		// 우측 자석 회전
		if (list[magnet].get(2) != list[magnet + 1].get(6)) {
			rotation(magnet + 1, !dir);
		}

		// 좌측 자석 회전
		if (list[magnet].get(6) != list[magnet - 1].get(2)) {
			rotation(magnet - 1, !dir);
		}

		// 회전
		if (dir) { // 시계
			list[magnet].add(0, list[magnet].get(7)); // 첫번째 위치에 마지막 값 넣기
			list[magnet].remove(8); // 마지막 값 제거
		} else { // 반시계
			list[magnet].add(list[magnet].get(0)); // 마지막에 첫번째 값 넣기
			list[magnet].remove(0); // 첫번째 값 제거
		}
	}
}