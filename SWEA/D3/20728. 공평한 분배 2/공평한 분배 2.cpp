#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, k;
		cin >> n >> k;
		vector<int> v;
		for (int i = 0; i < n; i++) {
			int num;
			cin >> num;
			v.push_back(num);
		}
		sort(v.begin(), v.end());
		int min = 1000000000;

		for (int i = 0; i < n - k + 1; i++) {
			if (min > v[i + k - 1] - v[i]) {
				min = v[i + k - 1] - v[i];
			}
		}

		cout << "#" << test_case << " " << min << "\n";
	}
}