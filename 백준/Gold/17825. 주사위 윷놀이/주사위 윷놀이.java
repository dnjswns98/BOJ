import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dice, horse;
	static int max;

	// map[0]은 일반 경로, map[1]~map[3]은 각각 지름길
	static int[][] map = { 
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1 },
			{ 10, 13, 16, 19, 25, 30, 35, 40, -1 },
			{ 20, 22, 24, 25, 30, 35, 40, -1 },
			{ 30, 28, 27, 26, 25, 30, 35, 40, -1 } 
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		dice = new int[10];
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		horse = new int[10]; // 매 턴마다 어떤 말을 움직일지 선택 (0~3)
		max = 0;
		dfs(0);
		
		System.out.println(max);
	}

	static void dfs(int cnt) {
		if (cnt == 10) {
			max = Math.max(max, simulate());
			return;
		}

		for (int i = 0; i < 4; i++) { // 중복조합으로 움직일 말 뽑기
			horse[cnt] = i;
			dfs(cnt + 1);
		}
	}

	
	static int simulate() {
		int[][] pos = new int[4][2]; // 각 말의 위치를 [말 번호][0 : 경로 번호, 1 : 인덱스] 로 표현
		int score = 0; // 점수 총합

		for (int i = 0; i < 10; i++) {
			int h = horse[i]; // 현재 말
			int route = pos[h][0];
			int idx = pos[h][1];
			
			if(map[route][idx] == -1) continue; // 이미 도착했는 말이면 제외
			
			// 다음으로 이동할 칸
			int nIdx = idx + dice[i];
			int nRoute = route;
			
			// 도착 칸 이상으로 이동했다면
			if(nIdx >= map[route].length - 1) {
				nIdx = map[route].length - 1;
				pos[h][1] = nIdx;
				continue;
			}
			else {			
				if(route == 0) { // 현재 일반 경로인 경우
					if(nIdx % 5 == 0 && nIdx != 20) { // 지름길로 가는 칸에 도달했다면
						nRoute = nIdx / 5;
						nIdx = 0;
					}
				}
			}
			
			// 다른 말이 있는지 체크
			for(int j = 0; j<4; j++) {
				if(j == h) continue;
				if(map[pos[j][0]][pos[j][1]] == -1) continue; // 이미 도착한 말은 제외
				
				if(pos[j][0] == nRoute && pos[j][1] == nIdx) // 같은 위치에 있는 말은 제외
					return 0;
				if(map[pos[j][0]][pos[j][1]] == 40 && map[nRoute][nIdx] == 40) // 40에 겹쳐있는 경우
					return 0;
				if(map[pos[j][0]][pos[j][1]] == 35 && map[nRoute][nIdx] == 35)
					return 0;
				if(map[pos[j][0]][pos[j][1]] == 30 && map[nRoute][nIdx] == 30 && pos[j][0] == nRoute && pos[j][1] == nIdx) 
					return 0;
				if(map[pos[j][0]][pos[j][1]] == 25 && map[nRoute][nIdx] == 25)
					return 0;
			}
			
			// 이동
			pos[h][0] = nRoute;
			pos[h][1] = nIdx;
			if(map[nRoute][nIdx] > 0) {
				score += map[nRoute][nIdx];
			}
		}
		
		return score;
	}
}