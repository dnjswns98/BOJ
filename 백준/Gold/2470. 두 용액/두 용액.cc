#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	int n;
	cin >> n;
	vector<int> v;
	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());
	int s = 0, e = n - 1;
	int sum = 0;
	int min = 2000000000;
	vector<int> ans(2);
	while (s < e) {
		sum = v[s] + v[e];
		if (abs(sum) < min) {
			min = abs(sum);
			ans[0] = v[s];
			ans[1] = v[e];
			if (sum == 0) break;
		}
		if (sum < 0) {
			s++;
		}
		else {
			e--;
		}
	}
	cout << ans[0] << " " << ans[1];
}