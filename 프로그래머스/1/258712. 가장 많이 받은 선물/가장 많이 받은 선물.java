import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] friendsGiftCount = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        
        //선물을 주고받은 관계에 따라 갯수 입력
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                String str = friends[i] + " " + friends[j];
                for(String gift : gifts) {
                    if(gift.equals(str)) {
                        friendsGiftCount[i][j]++;
                    }   
                }
            }
        }
        
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                System.out.print(friendsGiftCount[i][j] + " ");
            }
            System.out.println();
        }
        
        //선물 지수 입력
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                if(friendsGiftCount[i][j] != 0) {
                    giftIndex[i] += friendsGiftCount[i][j];
                    giftIndex[j] -= friendsGiftCount[i][j];
                }
            }
        }
        
        //선물 주고 받기
        int maxGift = 0;
        for(int i = 0; i < friends.length; i++) {
            int giftCount = 0;
            for(int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                
                if(friendsGiftCount[i][j] > friendsGiftCount[j][i]) {
                    giftCount++;
                }
                else if(friendsGiftCount[i][j] == friendsGiftCount[j][i]) {
                    if(giftIndex[i] > giftIndex[j])
                        giftCount++;
                }
            }
            if(maxGift < giftCount)
                maxGift = giftCount;
        }
        
        return maxGift;
    }
}