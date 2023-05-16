#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
using namespace std;

int dp[1000] = { 0 }, arr[1001];
int n, cnt = 1;
vector<int> v;
vector<int> longest[1001];

void solve() {
	for (int i = 1; i <= n; i++) {
		dp[i] = 1;
		longest[i].push_back(arr[i]);
		for (int j = 1; j < i; j++) {
			if (arr[i] > arr[j]) {
				if (dp[i] > dp[j]) continue;
				dp[i] = dp[j] + 1;
				longest[i].clear();
				longest[i] = longest[j];
				longest[i].push_back(arr[i]);
			}
		}

		if (v.size() < longest[i].size()) {
			v = longest[i];
		}
	}

	cout << v.size() << "\n";
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " ";
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	solve();
	
}