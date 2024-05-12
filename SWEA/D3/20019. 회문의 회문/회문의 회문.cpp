#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		string s;
		cin >> s;
		int len = s.size() - 1;
		bool chk = true;
		for (int i = 0; i < s.size() / 2; i++) {
			if (s[i] != s[len]) {
				chk = false;
				break;
			}
			len--;
		}

		len = (s.size() / 2) - 1;
		for (int i = 0; i < s.size() / 4; i++) {
			if (s[i] != s[len]) {
				chk = false;
				break;
			}
			len--;
		}

		len = (s.size() / 2) + 1;
		for (int i = s.size() - 1; i > s.size() * 0.75 - 1; i--) {
			if (s[i] != s[len]) {
				chk = false;
				break;
			}
			len++;
		}

		if(chk) cout << "#" << test_case << " " << "YES" << "\n";
		else cout << "#" << test_case << " " << "NO" << "\n";
	}
}