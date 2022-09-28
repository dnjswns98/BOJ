import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//n 입력
		int n =Integer.parseInt(bf.readLine());
		//배열 입력
		String[] s = bf.readLine().split(" ");
		//string형태를 int로 바꿔서 저장할 배열
		int[] arr = new int[n];
		//숫자들이 등장한 횟수를 저장할 배열
		int[] cnt = new int[1000001];
		//int배열에 저장, 카운트 세기
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(s[i]);
			cnt[arr[i]]++;
		}
		//결과를 저장할 배열
		int[] result = new int[n];
		//인덱스를 담을 stack
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<n; i++) {
			while(!stack.empty() && cnt[arr[stack.peek()]] < cnt[arr[i]])
				result[stack.pop()] = arr[i];
			stack.push(i);
		}
		while(!stack.empty())
			result[stack.pop()] = -1;
		for(int i=0; i<result.length; i++)
			bw.write(result[i]+" ");
		bw.flush();
	}
}