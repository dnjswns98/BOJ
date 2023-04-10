#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	int n, m;
	cin >> n >> m;
	vector<int> v;
	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}
	int s = 0, e = 0, result = 0;
	int sum = 0;
	while (s < n) {
		if (sum < m && e < n) {
			sum += v[e++];
		}
		else {
			sum -= v[s++];
		}

		if (sum == m) result++;
	}
	cout << result;
}