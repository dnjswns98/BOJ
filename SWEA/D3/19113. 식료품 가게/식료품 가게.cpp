#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		cin >> n;
		vector<int> v;
		int check[200] = { 0 };
		for (int i = 0; i < 2 * n; i++) {
			int num;
			cin >> num;
			v.push_back(num);
		}
		vector<int> ans;
		for (int i = 0; i < 2 * n - 1; i++) {
			for (int j = i + 1; 2 * n; j++) {
				if (check[i]) break;
				if (check[j]) continue;

				if (v[j] * 0.75 == v[i]) {
					check[i] = 1;
					check[j] = 1;
					ans.push_back(v[i]);
					break;
				}
			}
		}

		cout << "#" << test_case << " ";
		for (auto iter = ans.begin(); iter < ans.end(); iter++) {
			cout << *iter << " ";
		}
		cout << "\n";
	}
}