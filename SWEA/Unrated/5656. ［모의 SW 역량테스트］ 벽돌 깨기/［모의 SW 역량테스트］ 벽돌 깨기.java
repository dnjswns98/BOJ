/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	static int w;
	static int h;
	static int min;
	static int boom;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int t = Integer.parseInt(br.readLine());
    	for(int test = 1; test <= t; test++) {
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		
    		int[][] arr = new int[h][w];
    		min = 0;
    		for(int i = 0; i < h; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < w; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    				if(arr[i][j] > 0) min++;
    			}
    		}
    		
    		dfs(0, arr);
    		
    		System.out.println("#" + test + " " +min);
    	}
    }
    
    static void dfs(int cnt, int[][] arr) {
    	if (cnt == n) { // 구슬을 N번 떨어뜨렸을 때
            min = Math.min(min, count(arr));
            return;
        }
    	
    	for (int col = 0; col < w; col++) {
    		int[][] temp = copy(arr);
            drop(col, temp); //떨어트리기
            gravity(temp);
            dfs(cnt + 1, temp);
        }
    }
    
    static int[][] copy(int[][] arr) {
    	int[][] temp = new int[h][w];
    	for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				temp[i][j] = arr[i][j];
			}
		}
    	return temp;
    }
    
    static void drop(int col, int[][] temp) {
        for (int row = 0; row < h; row++) { //col은 고정하고 row탐색
            if (temp[row][col] > 0) { //첫번째 벽돌 만나면
            	Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{row, col, temp[row][col]}); //좌표, 범위 저장
                temp[row][col] = 0; // 해당 벽돌 제거

                while (!q.isEmpty()) {
                    int[] brick = q.poll();
                    int x = brick[0];
                    int y = brick[1];
                    int range = brick[2];        

                    for (int i = 0; i < 4; i++) { // 4방향 탐색
                        for (int j = 1; j < range; j++) { //폭발 범위
                            int nx = x + dx[i] * j;
                            int ny = y + dy[i] * j;
                            
                            if (nx < 0 || ny < 0 || nx >= h || ny >= w) //범위 밖
                            	break;
                            
                            if (temp[nx][ny] > 0) { //폭발범위 안에 벽돌 존재한다면
                                q.add(new int[]{nx, ny, temp[nx][ny]}); //좌표, 범위 저장
                                temp[nx][ny] = 0; // 벽돌 제거
                            }
                        }
                    }
                }
                
                return; //첫번째 벽돌만 부수고 빠져나와야함
            }
        }
    }
    
    static void gravity(int[][] temp) {
    	for (int col = 0; col < w; col++) {
            List<Integer> list = new ArrayList<>();
            for (int row = h - 1; row >= 0; row--) { //왼쪽아래부터 탐색시작
                if (temp[row][col] > 0) { //벽돌있으면
                    list.add(temp[row][col]); //벽돌 값 가지기
                    temp[row][col] = 0;
                }
            }
            int row = h - 1; //제일 아래로 고정
            for (int val : list) {
                temp[row--][col] = val; //밑에서부터 벽돌값 넣기
            }
        }
    }
    
    static int count(int[][] arr) { //벽돌 수 세기
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }
}