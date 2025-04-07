import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	static int p, q;
	static char[][] prr, qrr;
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			prr = new char[p][];
			for (int i = 0; i < p; i++) {
				prr[i] = br.readLine().toCharArray();
			}

			qrr = new char[q][];
			for (int i = 0; i < q; i++) {
				qrr[i] = br.readLine().toCharArray();
			}

			result = new int[q];
			Arrays.fill(result, -2);

			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (isPossible(r, c, s)) {
							computeMyIndent(r, c, s);
						}
					}
				}
			}

			sb.append("#").append(t);
			for (int i = 0; i < q; i++) {
				sb.append(" ").append(result[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean isPossible(int r, int c, int s) {
		int rCnt = 0, cCnt = 0, sCnt = 0;
		int indent = 0;
		for (int i = 0; i < p; i++) {
			int cnt = 0;
			for (char ch : prr[i]) { // 현재 행의 온점 개수 세기
				if (ch == '.')
					cnt++;
				else
					break;
			}

			indent = r * rCnt + c * cCnt + s * sCnt; // 실제 공백 개수
			if (indent != cnt) // 실제 공백 개수와 온점의 개수가 맞지 않다면
				return false;

			// 이전 행의 괄호 개수 세기
			for (char ch : prr[i]) {
				switch (ch) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}

		return true;
	}

	static void computeMyIndent(int r, int c, int s) {
		int rCnt = 0, cCnt = 0, sCnt = 0;
		int indent = 0;
		for (int i = 0; i < q; i++) {
			indent = r * rCnt + c * cCnt + s * sCnt;

			if (result[i] == -2) // 답을 구한 적이 없는 경우
				result[i] = indent;
			else if (result[i] != indent) // 기존 값과 다른 값이 들어온다면
				result[i] = -1; // 유일하지 않음

			// 이전 행의 괄호 개수 세기
			for (char ch : qrr[i]) {
				switch (ch) {
				case '(':
					rCnt++;
					break;
				case ')':
					rCnt--;
					break;
				case '{':
					cCnt++;
					break;
				case '}':
					cCnt--;
					break;
				case '[':
					sCnt++;
					break;
				case ']':
					sCnt--;
					break;
				}
			}
		}
	}
}