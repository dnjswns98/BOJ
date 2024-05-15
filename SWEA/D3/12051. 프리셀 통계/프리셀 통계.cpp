#include <iostream>

using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		long long n, pd, pg;
		bool chk = false;
		cin >> n >> pd >> pg;
		if (pg == 0) {
			if (pd == 0) chk = true;
			else {
				cout << "#" << t << " " << "Broken" << "\n";
				continue;
			}
		}
		else if (pg == 100) {
			if (pd == 100) chk = true;
			else {
				cout << "#" << t << " " << "Broken" << "\n";
				continue;
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((pd * i) % 100 == 0) {
				chk = true;
				break;
			}
		}

		if (chk) cout << "#" << t << " " << "Possible" << "\n";
		else cout << "#" << t << " " << "Broken" << "\n";
	}
}