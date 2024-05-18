#include <iostream>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s;
		cin >> s;
		int a = 1, b = 1;
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == 'L') {
				a = a;
				b = a + b;
			}
			else {
				a = a + b;
				b = b;
			}
		}

		cout << "#" << t << " " << a << " " << b << '\n';
	}
}