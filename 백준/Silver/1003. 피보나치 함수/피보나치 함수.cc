#include <iostream>
using namespace std;

int dp[41] = { 0,1 };

int fibonacci(int n) {
    if (n == 0 || n == 1) {
        return dp[n];
    }
    else if (dp[n] == 0) {
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }
    return dp[n];
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, t;
    cin >> t;
	while (t--) {
		cin >> n;
        if (n == 0) {
            cout << 1 << " " << 0 << "\n";
        }
        else cout << fibonacci(n-1) << " " << fibonacci(n) << "\n";
	}
}