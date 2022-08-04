#include <iostream>
#include <algorithm>
using namespace std;

int arr[300] = { 0 };
int dp[300] = { 0 }; //해당 계단까지의 최대합

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin >> arr[i];

    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];
    dp[3] = max(arr[1] + arr[3], arr[2] + arr[3]);
    for (int i = 4; i <= n; i++) {
        dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
    }
    cout << dp[n];
}