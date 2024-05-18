#include <iostream>
#include <map>
#include <algorithm>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s;
		cin >> s;
		map<char, int> m;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (m.find(s[i]) == m.end()) {
				m.insert(make_pair(s[i], 1));
				cnt++;
			}
			else {
				m[s[i]]++;
			}
		}

		bool chk = true;
		if (cnt != 2) chk = false;

		for (auto iter = m.begin(); iter != m.end(); iter++) {
			if (iter->second != 2) chk = false;
		}

		if (chk)
			cout << "#" << t << " " << "Yes" << '\n';
		else cout << "#" << t << " " << "No" << '\n';
	}
}