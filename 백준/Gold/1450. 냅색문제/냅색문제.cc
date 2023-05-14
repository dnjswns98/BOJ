#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


void dfs(int s, int e, int arr[], vector<long long>& v, long long sum) {
	if (s > e) {
		v.push_back(sum);
		return;
	}
	else {
		dfs(s + 1, e, arr, v, sum);
		dfs(s + 1, e, arr, v, sum + arr[s]);
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	long long n, c, ans = 0;
	cin >> n >> c;
	int arr[30];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	vector<long long> v1;
	vector<long long> v2;
	dfs(0, n / 2, arr, v1, 0);
	dfs(n / 2 + 1, n - 1, arr, v2, 0);
	sort(v2.begin(), v2.end());

	for (int i = 0; i < v1.size(); i++) {

		ans += upper_bound(v2.begin(), v2.end(), c - v1[i]) - v2.begin();
	}

	cout << ans;
}