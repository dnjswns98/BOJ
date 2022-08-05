#include <iostream>
#include <vector>
using namespace std;

int n;
vector<int> dp(1000001, 0);

int main() {
    cin >> n;
    
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i <= n; i++) {
        if (i % 2 == 0 && i % 3 == 0) {
            dp[i] = min(dp[i / 2] + 1, dp[i / 3] + 1);
        }
        else if (i % 2 == 0 && i % 3 != 0) {
            dp[i] = min(dp[i / 2] + 1, dp[i - 1] + 1);
        }
        else if (i % 2 != 0 && i % 3 == 0) {
            dp[i] = min(dp[i / 3] + 1, dp[i - 1] + 1);
        }
        else dp[i] = dp[i - 1] + 1;
    }
    cout << dp[n];
}