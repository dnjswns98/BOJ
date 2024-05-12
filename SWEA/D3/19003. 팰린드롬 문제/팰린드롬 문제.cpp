#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool IsPal(string s) {
	int right = s.size() - 1;
	for (int i = 0; i < s.size() / 2; i++) {
		if (s[i] != s[right]) {
			return false;
		}
		right--;
	}
	return true;
}

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m;
		cin >> n >> m;
		vector<string> v;
		string s;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			cin >> s;
			v.push_back(s);
		}
		
		bool check = false;
		for (int i = 0; i < n; i++) {
			string re = v[i];
			if (IsPal(re)) check = true;
			reverse(re.begin(), re.end());
			if (find(v.begin(), v.end(), re) != v.end() && IsPal(re) == false) {
				cnt ++;
			}
		}
		if (check) cnt++;

		

		cout << "#" << test_case << " " << cnt * m;

		cout << "\n";
	}
}