#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, cnt = 0;
int dp[1001] = { 0 }; //v[i] < v[i+1] 자기자신보다 작은 수가 몇개있는지 저장
int L_dp[1001]; //v[i] > v[i+1]

int main() {
    cin >> n;
    vector<int> v(n + 1, 0);
    for (int i = 1; i <= n; i++) {
        cin >> v[i];
    }

    dp[0] = 0;
    dp[1] = 1; //v[1]은 항상 v[0] = 0보다 크니까
    for (int i = 2; i <= n; i++) { //자신보다 오른쪽이 큰지 검사
        for (int j = 0; j < i; j++) {
            if (v[i] > v[j]) {
                if (dp[i] > dp[j])
                    continue;
                dp[i] = dp[j] + 1;
            }
        }
    }

    fill_n(L_dp, 1001, 1);
    for (int i = n; i >= 1; i--) { //자신보다 왼쪽이 큰지 검사
        for (int j = n; j > i; j--) {
            if (v[i] > v[j]) {
                if (L_dp[i] > L_dp[j])
                    continue;
                L_dp[i] = L_dp[j] + 1;
            }
        }
    }

    int result = 0;
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        result = max(result, dp[i] + L_dp[i]);
    }

    cout << result - 1;
}