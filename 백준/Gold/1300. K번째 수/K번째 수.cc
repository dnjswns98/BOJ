#include <iostream>
#include <algorithm>
using namespace std;

int n, k;
int ans = 2100000000;

bool solve(int mid) {
	int cnt = 0;
	for (int i = 1; i <= n; i++) {
		cnt += min(mid / i, n);
	}
	if (cnt >= k) {
		return true;
	}
	else return false;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	int left = 1;
	int right = k;
	while (left <= right) {
		int mid = (left + right) / 2;
		bool found = solve(mid);
		if (found) {
			ans = min(ans, mid);
			right = mid - 1;
		}
		else left = mid + 1;
	}
	cout << ans;
}