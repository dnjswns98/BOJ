#include <string>
#include <vector>

using namespace std;

int toBinary(int n){
    int cnt = 0;
    while(n != 0){
        if(n%2 == 1) cnt++;
        n/=2;
    }
    return cnt;
}

int solution(int n) {
    int a = toBinary(n);
    
    while(1){
        n++;
        if(a == toBinary(n)) break;
    }
    
    return n;
}