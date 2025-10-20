import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Long> number = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		if(n <= 10) System.out.println(n);
		else if(n >= 1023) System.out.println(-1);
		else {
			for(int i = 0; i<10; i++) {
				comb(1, i);
			}
			
			Collections.sort(number);
			System.out.println(number.get(n));
		}
	}
	
	
	static void comb(int idx, long num) {
		if(idx > 10) return;
		
		number.add(num);
		
		for(int i = 0; i<num % 10; i++) {
			comb(idx + 1, num * 10 + i);
		}
	}
}
