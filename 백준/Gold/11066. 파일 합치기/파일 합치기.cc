#include <iostream>
#include <algorithm>
using namespace std;
#define gar 2000000000

int dp[501][501];
int sum[501];

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int t, k, n;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> k;
		for (int j = 1; j <= k; j++) {
			cin >> n;
			sum[j] = sum[j - 1] + n;
		}

		for (int j = 1; j < k; j++) {
			for (int h = 1; h <= k - j; h++) {
				dp[h][h + j] = gar;
				for (int g = h; g < h + j; g++) {
					dp[h][h + j] = min(dp[h][h + j], dp[h][g] + dp[g + 1][h + j] + sum[h + j] - sum[h - 1]);
				}
			}
		}
		cout << dp[1][k] << "\n";
	}
}