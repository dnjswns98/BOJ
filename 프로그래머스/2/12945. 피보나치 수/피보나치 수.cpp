#include <string>
#include <vector>

int arr[100001];

using namespace std;

int solution(int n) {
    int answer = 0;
    
    arr[0] = 0;
    arr[1] = 1;
    
    for(int i = 2; i<=n; i++){
        arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
    }
    
    answer = arr[n];
    return answer;
}