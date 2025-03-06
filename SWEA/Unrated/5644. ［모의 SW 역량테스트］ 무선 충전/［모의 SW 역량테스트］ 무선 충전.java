import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class AP {
		int x;
		int y;
		int c;
		int p;

		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	static int n, m, result;
	static int Ax, Ay, Bx, By; // A와 B 위치
	static AP[] ap; // AP 정보
	static int[] A, B; // A,B 이동 경로
	static int[] dx = { 0, -1, 0, 1, 0 }; // 0 : 이동 x, 1 : 상, 2 : 우, 3 : 하, 4 : 좌
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			// 맵 크기 입력
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 총 이동 시간
			m = Integer.parseInt(st.nextToken()); // BC의 개수

			// 0 : 이동 x, 1 : 상, 2 : 우, 3 : 하, 4 : 좌
			// A 이동 경로
			A = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			// B 이동 경로
			B = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// 초기 A, B 좌표
			Ax = 1;
			Ay = 1;
			Bx = 10;
			By = 10;

			// AP의 정보
			ap = new AP[m];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap[i] = new AP(y, x, c, p);
			}

			result = 0;
			charge(); // 초기 위치에서 충전 시도

			// 매 시간마다 A, B의 위치에 따른 충전시도
			for (int i = 0; i < n; i++) {
				Ax += dx[A[i]];
				Ay += dy[A[i]];
				Bx += dx[B[i]];
				By += dy[B[i]];
				charge();
			}
			
			System.out.println("#" + test + " " + result);
		}
	}

	static void charge() {
		// A와 B가 충전할 수 있는 AP 저장
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		// A와 B가 충전 가능한지 검사
		for (int i = 0; i < m; i++) {
			if (isPossible(i, Ax, Ay)) {
				listA.add(i);
			}
			if (isPossible(i, Bx, By)) {
				listB.add(i);
			}
		}

		int max = 0;
		// A와 B가 충전 가능한 AP가 있다면
		if (listA.size() > 0 && listB.size() > 0) {
			// 같은 충전소라면 반씩 나눠가짐
			// 다른 충전소라면 각각 충전
			for (int a : listA) {
				for (int b : listB) {
					int power = 0;
					if (a == b)
						power = ap[a].p;
					else {
						power = ap[a].p + ap[b].p;
					}
					// 가장 큰 파워 저장
					max = Math.max(max, power);
				}
			}
		}
		// A만 충전 가능
		else if (listA.size() > 0) {
			for (int a : listA) {
				max = Math.max(max, ap[a].p);
			}
		}
		// B만 충전 가능
		else if (listB.size() > 0) {
			for (int b : listB) {
				max = Math.max(max, ap[b].p);
			}
		}
		
		result += max;
	}

	static boolean isPossible(int idx, int x, int y) {
		if (ap[idx].c >= Math.abs(ap[idx].x - x) + Math.abs(ap[idx].y - y)) {
			return true;
		}
		return false;
	}
}
