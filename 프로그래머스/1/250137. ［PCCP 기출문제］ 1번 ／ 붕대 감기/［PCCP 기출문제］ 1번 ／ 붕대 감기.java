class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        
        for(int i = 0; i<attacks.length; i++) {
            health -= attacks[i][1];
            if(health <= 0) {
                return -1;
            }
            
            if(i == attacks.length - 1) {
                break;
            }
            
            int cnt = 1;
            int time = attacks[i][0] + 1;
            while(time < attacks[i + 1][0]) {
                health += bandage[1];
                
                if(cnt == bandage[0]) {
                    health += bandage[2];
                    cnt = 0;
                }
                
                if(health >= maxHealth) {
                    health = maxHealth;
                    break;
                }
                
                cnt++;
                time++;
            }  
        }
        
        answer = health;
        return answer;
    }
}