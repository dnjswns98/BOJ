import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		int n = 64;
		int cnt = 0;
		while(x > 0) {
			if(n > x) {
				n /= 2;
			}
			else {
				x -= n;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
