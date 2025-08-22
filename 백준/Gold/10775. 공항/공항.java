import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		parents = new int[g + 1];
		for(int i = 1; i<=g; i++) {
			parents[i] = i;
		}
		
		int cnt = 0;
		for(int i = 0; i<p; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int possible = find(num);
			
			if(possible == 0) break;
				
			parents[possible] = possible - 1;
			cnt++;
		}
		
		System.out.println(cnt);
	}

	static int find(int x) {
		if(x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
}
