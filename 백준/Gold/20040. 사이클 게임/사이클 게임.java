import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parents = new int[n];
        for(int i = 0; i<n; i++) {
        	parents[i] = i;
        }
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	if(!union(from, to)) {
        		System.out.println(i + 1);
        		return;
        	}
        }
        
        System.out.println(0);
    }
    
    static int find(int x) {
    	if(x == parents[x])
    		return x;
    	return parents[x] = find(parents[x]);
    }
    
    static boolean union(int a, int b) {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	
    	if(aRoot == bRoot) return false;
    	
    	parents[aRoot] = bRoot;
    	return true;
    }
}
