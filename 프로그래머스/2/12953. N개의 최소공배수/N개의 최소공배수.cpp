#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int gcd(int a, int b){
    int A = max(a,b);
    int B = min(a,b);
    
    while(A%B){
        int r = A%B;
        A = B;
        B = r;
    }
    
    return B;
}

int solution(vector<int> arr) {
    int answer = arr[0];
    for(int i = 1; i<arr.size(); i++){
        int GCD = gcd(answer,arr[i]);
        int LCM = answer * arr[i] / GCD;
        answer = LCM;
    }
    return answer;
}