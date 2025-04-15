import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int[] pi = new int[pattern.length]; // 부분일치 테이블 만들기
		int j = 0;
		for(int i = 1; i<pattern.length; i++) { // 패턴에서 패턴을 찾기
			while(j > 0 && pattern[i] != pattern[j]) { // 접두사 접미사 일치x, 이전 정보를 이용
				j = pi[j - 1];
			}
			
			if(pattern[i] == pattern[j]) { // 현재 위치에서 일치하는지 확인
				pi[i] = ++j;
			}
			else {
				pi[i] = 0; // 접두사, 접미사 일치 x
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		j = 0;
		for(int i = 0; i < str.length; i++) {
			while(j > 0 && str[i] != pattern[j]) {
				j = pi[j - 1];
			}
			
			if(str[i] == pattern[j]) {
				if(j == pattern.length - 1) { // 일치가 발생한 위치가 패턴의 끝이라면 모두 같다는 뜻
					cnt++;
					result.add(i - j + 1);
					j = pi[j];
				}
				else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		for(int i = 0; i<result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}