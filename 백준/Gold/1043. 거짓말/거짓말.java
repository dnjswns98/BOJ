import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // 진실 아는 사람 입력
        st = new StringTokenizer(br.readLine());
        int tCnt = Integer.parseInt(st.nextToken());
        if (tCnt == 0) { // 진실 아는 사람이 없으면 모든 파티 가능
            System.out.println(m);
            return;
        }
        int[] truthPeople = new int[tCnt];
        for (int i = 0; i < tCnt; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 정보 저장
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) parties.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pCnt = Integer.parseInt(st.nextToken());

            int first = Integer.parseInt(st.nextToken());
            parties.get(i).add(first);

            for (int j = 1; j < pCnt; j++) {
                int b = Integer.parseInt(st.nextToken());
                parties.get(i).add(b);
                union(first, b); // 같은 파티 사람이면 무조건 같은 집합
            }
        }

        // 진실 아는 사람들의 루트 집합 구하기
        Set<Integer> truthRoots = new HashSet<>();
        for (int t : truthPeople) {
            truthRoots.add(find(t));
        }

        // 각 파티 검사
        int cnt = 0;
        for (List<Integer> party : parties) {
            boolean hasTruth = false;
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    hasTruth = true;
                    break;
                }
            }
            if (!hasTruth) cnt++;
        }

        System.out.println(cnt);
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;

        // 작은 집합을 큰 집합 밑에 붙이기 (union by size)
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
        }
    }
}
