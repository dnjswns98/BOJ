#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
    long long answer[2001];
    answer[0] = 1;
    answer[1] = 1;
    for(int i = 2; i<=n; i++){
        answer[i] = (answer[i-1] + answer[i-2]) % 1234567;
    }
    return answer[n];
}