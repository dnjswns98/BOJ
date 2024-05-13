#include <iostream>

using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string a, b, ans;
		cin >> a >> b;

		if (a != b) ans = '1';
		else ans = a;

		cout << "#" << t << " " << ans << "\n";
	}
}