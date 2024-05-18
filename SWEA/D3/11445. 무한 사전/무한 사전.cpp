#include <iostream>
#include <string>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s1, s2;
		cin >> s1 >> s2;
		bool chk = true;
		if (s2.size() - s1.size() == 1) {
			bool flag = false;
			for (int i = 0; i < s1.size(); i++) {
				if (s1[i] != s2[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				if (s2[s2.size() - 1] == 'a') chk = false;
			}
		}
		
		if (chk)
			cout << "#" << t << " " << "Y" << '\n';
		else cout << "#" << t << " " << "N" << '\n';
	}
}