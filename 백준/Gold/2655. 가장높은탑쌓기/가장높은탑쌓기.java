import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Block implements Comparable<Block> {
		int num;
		int width;
		int h;
		int w;

		public Block(int num, int width, int h, int w) {
			this.num = num;
			this.width = width;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Block o) {
			return Integer.compare(o.width, this.width);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		Block[] block = new Block[n];
		block[0] = new Block(0, 0, 0, 0);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken()); // 넓이
			int h = Integer.parseInt(st.nextToken()); // 높이
			int w = Integer.parseInt(st.nextToken()); // 무게
			block[i] = new Block(i + 1, width, h, w);
		}
		Arrays.sort(block); // 넓이를 기준으로 내림차순 정렬

		int max = 0; // 역추적을 위해
		int[] dp = new int[n]; // 현재 i가 탑의 제일 위에 있을 때의 최대 높이
		for (int i = 0; i < n; i++) {
			dp[i] = block[i].h;
			for (int j = 0; j < i; j++) {
				if (block[i].w < block[j].w) {// 현재 벽돌보다 밑의 벽돌의 무게가 더 큰 경우 쌓기 가능
					dp[i] = Math.max(dp[i], dp[j] + block[i].h);
				}
			}
			max = Math.max(max, dp[i]);
		}

		Deque<Integer> result = new ArrayDeque<>();
		while(max > 0) {
			for(int i = n - 1; i>=0; i--) {
				if(dp[i] == max) {
					max -= block[i].h;
					result.add(block[i].num);
				}
			}
		}
		
		System.out.println(result.size());
		while(!result.isEmpty()) {
			System.out.println(result.poll());
		}
	}
}