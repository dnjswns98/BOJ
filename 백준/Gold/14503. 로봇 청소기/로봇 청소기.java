import java.util.Scanner;

public class Main {
	
	static int N, M;
    static int[][] room;
    static boolean[][] cleaned;
    static int x, y, d;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        x = sc.nextInt();
        y = sc.nextInt();
        d = sc.nextInt();
        
        room = new int[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(cleanRoom());
    }
    
    public static int cleanRoom() {
        int cleanedCount = 0;
        
        while (true) {
            //현재 위치 청소
            if (!cleaned[x][y]) {
                cleaned[x][y] = true;
                cleanedCount++;
            }
            
            //주변 4칸 확인
            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (room[nx][ny] == 0 && !cleaned[nx][ny]) {
                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }
            
            //청소할 곳을 찾았으면 이동
            if (found) continue;
            
            //후진 가능하면 후진
            int back = (d + 2) % 4;
            int nx = x + dx[back];
            int ny = y + dy[back];
            
            if (room[nx][ny] == 1) break; // 후진할 곳이 벽이면 종료
            
            x = nx;
            y = ny;
        }
        
        return cleanedCount;
    }
    
}