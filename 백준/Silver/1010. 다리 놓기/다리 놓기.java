import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		
		// m개 중에 n개를 순서 상관 없이 뽑기 = 조합
		// (2 1 5) 와 (1 2 5) 는 같은 경우
		// 즉, 다리가 서로 겹쳐지는 경우는 있을 수 없음
		int[][] dp = new int[30][30];
		
		// nC1 = 1, nC0 = 1
		for(int i = 0; i<30; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		// nCm = nCm-1 + n-1Cm-1
		for(int i = 2; i<30; i++) {
			for(int j = 1; j<30; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}

		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(dp[m][n]).append('\n');
		}
		
		System.out.println(sb);
	}
}