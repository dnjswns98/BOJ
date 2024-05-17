#include <iostream>

using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		bool chk = false;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i * j == n) {
					chk = true;
					break;
				}
			}
			if (chk) break;
		}

		if (chk) cout << "#" << t << " " << "Yes" << "\n";
		else cout << "#" << t << " " << "No" << "\n";
	}
}