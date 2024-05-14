#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void) {

	int test;
	cin >> test;
	bool chk[50] = { false };
	for (int t = 1; t <= test; t++) {
		string s;
		cin >> s;
		int cnt = 0;
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == '(') {
				if (s[i + 1] == ')' || s[i + 1] == '|') {
					cnt++;
					chk[i] = true;
					chk[i + 1] = true;
				}
			}
			else if (s[i] == ')') {
				if (s[i - 1] == '|') cnt++;
			}
		}
		cout << "#" << t << " " << cnt << '\n';
	}
}