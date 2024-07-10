#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    
    for(long long i = left; i <= right; i++){
        long long x = i/n; //몇번째 행인지
        long long y = i%n; //몇번째 열인지
        if(x > y) answer.push_back(x+1);
        else answer.push_back(y+1);
    }
    
    return answer;
}