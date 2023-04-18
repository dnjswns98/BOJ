#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;
	vector<int> v(n+1, 1);
	v.push_back(2);
	for (int i = 2; i * i <= n; i++) {
		if (v[i] == 0) continue;
		for (int j = i + i; j <= n; j += i) {
			v[j] = 0;
		}
	}

	vector<int> prime;
	for (int i = 2; i <= n; i++) {
		if (v[i]) prime.push_back(i);
	}

	int start = 0, end = 0;
	int sum = 0;
	int ans = 0;
	int size = prime.size();
	while (1) {
		if (sum == 0 && end == size) break;
		if (sum == n) {
			ans++;
			sum -= prime[start++];
		}
		else if (sum < n && end < size) {
			sum += prime[end++];
		}
		else {
			sum -= prime[start++];
		}
	}
	cout << ans;
}