#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	int n, m;
	cin >> n;
	vector<int> v;
	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}
	cin >> m;
	sort(v.begin(), v.end());
	int ans = 0, s = 0, e = n - 1;
	int sum = 0;
	while (s < e) {
		sum = v[s] + v[e];
		if (sum < m) {
			s++;
		}
		else if (sum > m) {
			e--;
		}
		else {
			ans++;
			s++;
			e--;
		}
	}
	cout << ans;
}