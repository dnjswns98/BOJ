import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String boom = bf.readLine();
		
		Stack<Character> s = new Stack<>();
		for(int i = 0; i<str.length(); i++) {
			s.push(str.charAt(i));
			
			if(s.size() >= boom.length()) {
				boolean check = true;
				
				for(int j = 0; j<boom.length(); j++) {
					if(s.get(s.size()-boom.length()+j) != boom.charAt(j)) {
						check = false;
						break;
					}
				}
				
				if(check) {
					for(int j = 0; j<boom.length(); j++) {
						s.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Character c : s) {
			sb.append(c);
		}
		if(sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb);
	}
}