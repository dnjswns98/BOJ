import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int INF = 100000000;
        
        int[][] arr = new int[n][n];
        for(int i = 0; i<n; i++) {
        	String s = br.readLine();
        	for(int j = 0; j<n; j++) {
        		if(s.charAt(j) == 'Y') {
        			arr[i][j] = 1;
        		}
        		else {
        			arr[i][j] = INF;
        		}
        	}
        }
        
        for(int k = 0; k<n; k++) {
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<n; j++) {
        			if(arr[i][j] > arr[i][k] + arr[k][j]) {
        				arr[i][j] = arr[i][k] + arr[k][j];
        			}
        		}
        	}
        }
        
        int max = 0;
        for(int i = 0; i<n; i++) {
        	int cnt = 0;
        	for(int j = 0; j<n; j++) {
        		if (i == j) continue; 
        		if(arr[i][j] <= 2) cnt++;
        	}
        	max = Math.max(max, cnt);
        }
        
        System.out.println(max);
    }
}
