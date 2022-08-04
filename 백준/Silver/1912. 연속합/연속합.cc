#include <iostream>
#include <vector>
using namespace std;

int n, maxSum; 
int tmp;
int sum[100001] = {0};
vector<int> v;

void f() {
    tmp = maxSum = sum[0] = v[0];
    for (int i = 1; i < n; i++) {
        if (v[i] < tmp + v[i]) { //현재값과 현재값+전값을 비교
            sum[i] = tmp + v[i];
        }
        else {
            sum[i] = v[i];
        }
        tmp = sum[i]; //값을 임시 저장한다.
        //연속하는 최대합을 구하는 것이기 때문에 전 값을 저장해야함

        if (maxSum < sum[i])
            maxSum = sum[i];
    }
    cout << maxSum;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        v.push_back(k);
    }
    f();
}