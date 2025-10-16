import java.io.*;
import java.util.*;

public class Main {

	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int end = Integer.parseInt(br.readLine());

		cnt = new int[10];

		int start = 1; // 1 ~ end까지 모든 수 구해야함
		int digit = 1; // 자릿수

		while (start <= end) {

			// 1의 자리가 0이 될 때까지 시작 페이지를 1씩 증가
			while (start < 10 && start <= end) {
				cnt[start++] += digit;
			}

			// 1의 자리가 9가 될 때까지 마지막 페이지를 1씩 감소
			while (end % 10 != 9 && start <= end) {
				count(end--, digit);
			}
			
			if(start > end) break;

			for (int i = 0; i < 10; i++) {
				cnt[i] += ((end / 10) - (start / 10) + 1) * digit;
			}

			end /= 10;
			start /= 10;
			digit*=10;
		}
		
		for(int i = 0; i<10; i++) {
			System.out.print(cnt[i] + " ");
		}
	}

	static void count(int num, int digit) {
		while (num > 0) {
			cnt[num % 10] += digit;
			num /= 10;
		}
	}
}
