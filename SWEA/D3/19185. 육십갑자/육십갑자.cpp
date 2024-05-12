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
		int n, m, q;
		cin >> n >> m;
		vector<string> v1;
		vector<string> v2;
		for (int i = 0; i < n; i++) {
			string s;
			cin >> s;
			v1.push_back(s);
		}

		for (int i = 0; i < m; i++) {
			string s;
			cin >> s;
			v2.push_back(s);
		}

		cout << "#" << test_case << " ";
		cin >> q;
		for (int i = 0; i < q; i++) {
			int num;
			cin >> num;
			int a = num % n;
			int b = num % m;
			if (a == 0) a = n;
			if (b == 0) b = m;
			cout << v1[a - 1] << v2[b - 1] << " ";
		}
		cout << '\n';
	}
}