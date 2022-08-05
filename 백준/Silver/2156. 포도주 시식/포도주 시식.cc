#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int dp[10001] = { 0 };

int main() {
    cin >> n;
    vector<int> v(n + 1, 0);
    for (int i = 1; i <= n; i++) {
        cin >> v[i];
    }

    dp[0] = 0;
    dp[1] = v[1];
    dp[2] = v[1] + v[2];
    for (int i = 3; i <= n; i++) {
        dp[i] = max(dp[i - 2] + v[i], max(dp[i - 1], dp[i - 3] + v[i - 1] + v[i]));
    }

    cout << dp[n];
}