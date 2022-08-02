#include <iostream>
using namespace std;

int dp[1001][1001];

int main() {
    int n, k;
    cin >> n >> k;
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
        dp[i][1] = i;
        dp[i][i] = dp[i][0] = 1;
    }
    for (int i = 3; i <= n; i++) {
        for (int j = 2; j < i; j++) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007; // 매번 10007로 나눠주지 않으면 자료형의 크기를 초과함
        }
    }

    cout << dp[n][k];
}