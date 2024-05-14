#include <iostream>
#include <algorithm>
using namespace std;


int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s;
		cin >> s;
		int cnt = 0;
		int len = s.size();
		bool chk = false;
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == 'o') cnt++;
		}
		int chance = 15 - len;
		if (cnt + chance >= 8) chk = true;

		if (chk) cout << "#" << t << " YES" << '\n';
		else cout << "#" << t << " NO" << '\n';

	}
}