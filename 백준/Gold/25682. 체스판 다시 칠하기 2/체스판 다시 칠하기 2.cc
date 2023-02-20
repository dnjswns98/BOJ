#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> v;
int dp[2001][2001] = { 0 };
int n, m, k;

int board(char color) {
	int val;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if ((i + j) % 2 == 0) {
				if (color != v[i][j]) val = 1;
				else val = 0;
			}
			else {
				if (color != v[i][j]) val = 0;
				else val = 1;
			}
			dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + val;
		}
	}
	
	int cnt, result = 4000000;
	for (int i = 0; i <= n - k; i++) {
		for (int j = 0; j <= m - k; j++) {
			cnt = dp[i + k][j + k] - dp[i][j + k] - dp[i + k][j] + dp[i][j];
			result = cnt < result ? cnt : result;
		}
	}

	return result;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> m >> k;

	string str;
	for (int i = 0; i < n; i++) {
		cin >> str;
		v.push_back(str);
	}
	
	cout << (board('B') < board('W') ? board('B') : board('W'));
}