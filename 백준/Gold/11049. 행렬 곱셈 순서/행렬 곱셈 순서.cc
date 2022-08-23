#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define gar 2000000000
//참고 : https://cocoon1787.tistory.com/318

int dp[500][500] = { 0 };

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	vector<pair<int, int>> v;
	int tmp1, tmp2;
	for (int i = 0; i < n; i++) {
		cin >> tmp1 >> tmp2;
		v.push_back(make_pair(tmp1, tmp2));
	}
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < n - i; j++) {
			dp[j][i + j] = gar;
			for (int k = j; k <= i + j; k++) {
				dp[j][i + j] = min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + v[j].first * v[k].second * v[i + j].second);
			}
		}
	}
	cout << dp[0][n - 1];
}