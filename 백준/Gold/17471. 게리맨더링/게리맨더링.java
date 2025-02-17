import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] people; // 구역별 인구수 저장
	static List<List<Integer>> graph; // 각 노드가 방문하는 구역 저장
	static boolean[] selected;
	static int n;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		people = new int[n];
		selected = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			graph.add(new ArrayList<>());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		divide(0);

		if (min == Integer.MAX_VALUE) { // 두 선거구로 나눌 수 없는 경우
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void divide(int idx) {
		if (idx == n) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					aList.add(i);
				} else {
					bList.add(i);
				}
			}

			if (aList.size() == n || bList.size() == n)
				return;

			if (linked(aList) && linked(bList)) { // 두 선거구가 연결되어 있다면
				min = Math.min(min, getDiff());
			}
			return;
		}

		selected[idx] = true; // A구역에 넣는 경우
		divide(idx + 1);
		selected[idx] = false; // B구역에 넣는 경우
		divide(idx + 1);
	}

	static boolean linked(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n]; // 방문했는지 체크

		q.offer(list.get(0));
		visited[list.get(0)] = true;
		int count = 1; // 방문한 구역 수
		while (!q.isEmpty()) {
			int idx = q.poll();
			for (int i = 0; i < graph.get(idx).size(); i++) {
				int next = graph.get(idx).get(i);
				if (list.contains(next) && !visited[next]) {
					q.offer(next);
					visited[next] = true;
					count++;
				}
			}
		}

		if (count == list.size()) {
			return true;
		}
		return false;
	}

	static int getDiff() { // 인구수 차이 구하기
		int aCount = 0;
		int bCount = 0;
		for (int i = 0; i < n; i++) {
			if (selected[i]) { // a구역인 경우
				aCount += people[i];
			} else { // b구역인 경우
				bCount += people[i];
			}
		}

		if (aCount < bCount) { // 절대값 구하기위해 값 바꾸기
			int temp = aCount;
			aCount = bCount;
			bCount = temp;
		}
		return aCount - bCount;
	}
}
