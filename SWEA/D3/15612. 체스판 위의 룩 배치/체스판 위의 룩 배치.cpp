#include <iostream>
#include <string>

using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		char c[8][8];
		int rook = 0;
		for (int i = 0; i < 8; i++) {
			string s;
			cin >> s;
			for (int j = 0; j < 8; j++) {
				c[i][j] = s[j];
				if (s[j] != '.') rook++;
			}
		}
		bool chk1 = false;
		for (int i = 0; i < 8; i++) {
			int cnt = 0;
			for (int j = 0; j < 8; j++) {
				if (c[i][j] != '.') cnt++;
				if (cnt == 2) {
					chk1 = true;
					break;
				}
			}
			if (chk1) break;
		}
		bool chk2 = false;
		for (int i = 0; i < 8; i++) {
			int cnt = 0;
			for (int j = 0; j < 8; j++) {
				if (c[j][i] != '.') cnt++;
				if (cnt == 2) {
					chk2 = true;
					break;
				}
			}
			if (chk2) break;
		}
		

		if(chk1 || chk2 || rook != 8) cout << "#" << t << " " << "no" << "\n";
		else cout << "#" << t << " " << "yes" << "\n";
	}
}