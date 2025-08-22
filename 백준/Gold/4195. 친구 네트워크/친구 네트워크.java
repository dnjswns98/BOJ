import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<String, String> parents;
	static HashMap<String, Integer> size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());

			parents = new HashMap<>();
			size = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!parents.containsKey(a)) {
					parents.put(a, a);
					size.put(a, 1);
				}
				if (!parents.containsKey(b)) {
					parents.put(b, b);
					size.put(b, 1);
				}
				sb.append(union(a, b)).append('\n');
			}
		}
		System.out.println(sb);
	}

	static String find(String x) {
		if (x == parents.get(x))
			return x;
		parents.put(x, find(parents.get(x)));
		return parents.get(x);
	}

	static int union(String a, String b) {
		String aRoot = find(a);
		String bRoot = find(b);

		if (!aRoot.equals(bRoot)) {
			parents.put(bRoot, aRoot);

			int aSize = size.get(aRoot);
			int bSize = size.get(bRoot);
			size.put(aRoot, aSize + bSize);
		}
		
		return size.get(aRoot);
	}
}
