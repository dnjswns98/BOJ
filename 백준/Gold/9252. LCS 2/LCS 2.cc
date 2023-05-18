#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int dp[1001][1001] = { 0 };

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string s1, s2;
	cin >> s1 >> s2;

	for (int i = 1; i <= s1.size(); i++) {
		for (int j = 1; j <= s2.size(); j++) {
			if (s1[i - 1] == s2[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	int row = s1.size();
	int col = s2.size();
	string result = "";
	while(dp[row][col]) {
		if (dp[row][col] == dp[row - 1][col])
			row--;
		else if (dp[row][col] == dp[row][col - 1])
			col--;
		else {
			result += s1[row - 1];
			row--;
			col--;
		}
	}

	cout << dp[s1.size()][s2.size()] << "\n";
	if (result.size() > 0) {
		reverse(result.begin(), result.end());
		cout << result;
	}
}