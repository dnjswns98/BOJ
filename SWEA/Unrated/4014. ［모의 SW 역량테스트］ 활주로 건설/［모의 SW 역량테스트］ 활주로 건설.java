import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, x, result;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			// 행과 열 모두 검사해야하는데 하나의 배열로 처리한다면
			// 경사로 검사 로직을 다르게 2개 짜야함
			// 따라서 열을 행으로 변환해서 하나의 로직으로 검사
			int[][] rowArr = new int[n][n];
			int[][] colArr = new int[n][n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					rowArr[i][j] = Integer.parseInt(st.nextToken());
					colArr[j][i] = rowArr[i][j];
				}
			}
			
			result = 0;
			search(rowArr);
			search(colArr);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void search(int[][] arr) {
		for(int i = 0; i<n; i++) {
			int sameHeight = 1; // 같은 높이를 가지는 연속된 블록 수
			boolean check = true;
			for(int j = 1; j<n; j++) {
				if(arr[i][j - 1] != arr[i][j]) { // 현재 블록과 전의 블록의 높이가 다르면
					// 내려가는 경사로
					if(arr[i][j - 1] == arr[i][j] + 1) { // 높이가 1 차이라면
						int k = 1;
						while(j + k < n && arr[i][j] == arr[i][j + k] && k < x) {
							k++;
						}
						
						if(k == x) { // 경사로 설치가 x길이만큼 가능하다면
							sameHeight = 0;
							j += k - 1; // 다음 index로 넘어가야함. for문으로 j값이 1증가하므로 -1 해줘야함
						}
						else { // 경사로 설치 불가
							check = false;
							break;
						}
					}
					// 올라가는 경사로
					else if(arr[i][j - 1] + 1 == arr[i][j]){
						if(sameHeight >= x) { // 경사로 설치가 가능하다면
							sameHeight = 1;
						}
						else { // 설치 불가능
							check = false;
							break;
						}
					}
					// 높이 차가 1 이상이면 경사로 만들 수 없음
					else {
						check = false;
						break;
					}
				}
				else {
					sameHeight++;
				}
			}
			
			if(check) result++;
		}
	}
}
