import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        
        int[] cnt = new int[N + 2];
        for(int i : stages) {
            cnt[i]++;
        }
        
        int size = stages.length;
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            double fail;
            if(size == 0) fail = 0.0;
            else fail = cnt[i] / (double)size;
            
            map.put(i, fail);
            size -= cnt[i];
        }
        
        List<Integer> key = new ArrayList<>(map.keySet());
        Collections.sort(key, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                int cmp = Double.compare(map.get(o2), map.get(o1));
                if(cmp == 0){
                    return o1 - o2;
                }
                return cmp;
            }
        });
        
        return key;
    }
}