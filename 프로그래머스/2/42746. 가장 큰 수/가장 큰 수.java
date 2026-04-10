import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] nums = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .toArray(String[]::new);
        
        if(nums[0].equals("0")) return "0";
        
        for(String n : nums) {
            sb.append(n);
        }
        
        return sb.toString();
    }
}