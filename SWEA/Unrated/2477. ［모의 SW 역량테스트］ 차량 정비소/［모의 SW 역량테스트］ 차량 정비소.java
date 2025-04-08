import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	
	static class Person {
		int num;
		int arriveTime;
		int receptionIdx;
		int receptionStartTime;
		int receptionEndTime;
		int repairIdx;
		int repairStartTime;
		
		public Person(int num, int arriveTime) {
			this.num = num;
			this.arriveTime = arriveTime;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] arr = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] brr = new int[m + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=m; i++) {
				brr[i] = Integer.parseInt(st.nextToken());
			}
			
			Deque<Person> people = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<k; i++) {
				people.add(new Person(i + 1, Integer.parseInt(st.nextToken())));
			}
			
			Person[] reception = new Person[n + 1];
			PriorityQueue<Person> receptionWait = new PriorityQueue<>(new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					return Integer.compare(o1.num, o2.num);
				}
			});

			Person[] repair = new Person[m + 1];
			PriorityQueue<Person> repairWait = new PriorityQueue<>(new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					if(o1.receptionEndTime == o2.receptionEndTime) {
						return Integer.compare(o1.receptionIdx, o2.receptionIdx);
					}
					return Integer.compare(o1.receptionEndTime, o2.receptionEndTime);
				}
			});
			
			ArrayList<Person> result = new ArrayList<>();
			int time = 0;
			while(true) {
				// 접수 창구에서 빼서 정비 창구 대기 순번에 넣기
				for(int i = 1; i<=n; i++) {
					if(reception[i] != null && reception[i].receptionStartTime + arr[i] == time) {
						reception[i].receptionEndTime = time; // 대기 시작하는 시간을 기록
						repairWait.add(reception[i]);
						reception[i] = null;
					}
				}
				
				// 정비 창구에서 빼기
				for(int i = 1; i<=m; i++) {
					if(repair[i] != null && repair[i].repairStartTime + brr[i] == time) {
						result.add(repair[i]); // 결과에 넣기
						repair[i] = null;
					}
				}
				
				// 모든 고객이 접수와 정비를 마쳤다면 빠져나가기
				if(result.size() == k) break;
				
				// 접수 창구 대기 순번 뽑기
				while(!people.isEmpty()) {
					if(people.peek().arriveTime > time) // 현재 시간보다 도착시간이 더 크다면
						break;
					receptionWait.add(people.poll()); // 접수 대기에 넣기
				}
			
				// 접수 창구에 넣기
				for(int i = 1; i<=n; i++) {
					if(reception[i] == null && !receptionWait.isEmpty()) {
						reception[i] = receptionWait.poll();
						reception[i].receptionStartTime = time; // 접수 시작하는 시간 저장
						reception[i].receptionIdx = i;
					}
				}
				
				// 정비 창구에 넣기
				for(int i = 1; i<=m; i++) {
					if(repair[i] == null && !repairWait.isEmpty()) {
						repair[i] = repairWait.poll();
						repair[i].repairStartTime = time; // 정비 창구 시작 시간
						repair[i].repairIdx = i;
					}
				}
				
				time++;
			}
			
			int sum = 0;
			for(Person p : result) {
				if(p.receptionIdx == a && p.repairIdx == b)
					sum += p.num;
			}

			if(sum == 0) sum = -1;
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}