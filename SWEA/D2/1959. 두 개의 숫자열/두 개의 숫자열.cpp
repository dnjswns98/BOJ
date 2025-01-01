import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            for(int i = 0; i<m; i++) {
                b[i] = sc.nextInt();
            }
            
            if(n > m){
                int temp = m;
                m = n;
                n = temp;
                
                int[] tempArr = b;
                b = a;
                a = tempArr;
            }
            
            int max = 0;
            for(int i = 0; i<m-n+1; i++) {
                int sum = 0;
                for(int j = 0; j<n; j++){
                	sum += a[j] * b[i+j];
                }
                if(sum > max)
                    max = sum;
            }
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}