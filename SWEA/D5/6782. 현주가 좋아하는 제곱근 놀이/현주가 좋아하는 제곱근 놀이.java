import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++) {
            // 10^12
            long n = Long.parseLong(br.readLine());
            int result = 0;
            while(n!=2) {
                double t = Math.sqrt(n);
                if((int)t == t) {
                    n = (int)t;
                }else {
                    t = (int)t;
                    result += ((t+1)*(t+1)-n);
                    n = (int)Math.sqrt((t+1)*(t+1));
                }
                result++;
            }
            bw.write("#"+z+" "+result+"\n");
        }
        bw.flush();
    }// end of main
}// end of class