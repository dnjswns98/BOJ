import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			LinkedList<String> list = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				list.add(st.nextToken());
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				char command = st.nextToken().charAt(0);
				int x, y;
				ListIterator<String> iter;
				switch (command) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					iter = list.listIterator(x); // 해당 위치까지 이동 O(x)
					for (int j = 0; j < y; j++) {
						iter.add(st.nextToken()); // O(1) 중간 삽입
					}
					break;
				case 'D':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					iter = list.listIterator(x); // 해당 위치까지 이동 O(x)
					for (int j = 0; j < y && iter.hasNext(); j++) {
						iter.next(); // 다음 요소 반환, {1, 2, 3, 4} 가 들어가 있고 iter이 1이라면 next를해야 1에 있는 요소 2가 반환되고 iter은 다음 위치로 간다.
						iter.remove(); // 방금 반환한 요소 제거, O(1) 삭제
					}
					break;
				case 'A':
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(st.nextToken());
					}
					break;
				}
			}

			sb.append("#").append(test).append(" ");
			ListIterator<String> iter = list.listIterator();
			for (int i = 0; i < 10 && iter.hasNext(); i++) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}