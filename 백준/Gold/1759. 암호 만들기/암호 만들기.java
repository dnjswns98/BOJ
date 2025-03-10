import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[] arr, result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 사전순으로 암호를 만들어야하고 출력을 해야한다.
		Arrays.sort(arr);

		result = new char[n];
		sb = new StringBuilder();
		dfs(0, 0);
		
		System.out.println(sb);
	}

	static void dfs(int cnt, int start) {
		if(cnt == n) {
			// 모음 1개, 자음 2개 이상인지 확인	
			int Acnt = 0;
			int Bcnt = 0;
			for(char c : result) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') Acnt++;
				else Bcnt++;
			}
			
			if(Acnt >= 1 && Bcnt >= 2)
				sb.append(result).append('\n');
			return;
		}

		for(int i = start; i<m; i++) {		
			result[cnt] = arr[i];
			dfs(cnt + 1, i + 1);
		}
	}
}
