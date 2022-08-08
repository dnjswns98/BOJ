#include <iostream>
#include <vector>
using namespace std;

int n, m, num;

int main() {
    ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
    
    cin >> n >> m;
    vector<int> dp(n + 1);

    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
        cin >> num;
        dp[i] = dp[i - 1] + num;
    }

    int a, b;
    for (int i = 1; i <= m; i++) {
        cin >> a >> b;
        cout << dp[b] - dp[a - 1] << "\n";
    }
}