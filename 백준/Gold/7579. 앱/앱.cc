#include <iostream>
#include <algorithm>

using namespace std;
//참고 : https://cocoon1787.tistory.com/319
int arr[101] = { 0 };
int cost[101] = { 0 };
int dp[101][10001] = { 0 };
int n, m;
int sum = 0;

void input() {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	for (int i = 1; i <= n; i++) {
		cin >> cost[i];
		sum += cost[i];
	}
}

void solution() {
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= sum; j++) {
			if (j - cost[i] >= 0)
				dp[i][j] = dp[i - 1][j - cost[i]] + arr[i];

			dp[i][j] = max(dp[i][j], dp[i - 1][j]);
		}
	}

	for (int i = 0; i <= sum; i++) {
		if (dp[n][i] >= m) {
			cout << i;
			break;
		}
	}
}

void solve() {
	input();
	solution();
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	solve();
}