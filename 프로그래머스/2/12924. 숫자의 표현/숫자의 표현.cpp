#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int sum = 0;
    
    for(int i = 1; i<=n; i++){
        sum += i;
        if(sum >= n){
            answer++;
        }
        for(int j = i+1; j<=n; j++){
            sum += j;
            if(sum == n){
                answer++;
                break;
            }
            else if(sum > n) break;
        }
        
        sum = 0;
    }
    
    return answer;
}