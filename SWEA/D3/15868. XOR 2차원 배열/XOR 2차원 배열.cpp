#include <iostream>
#include <string>
#include <cmath>
using namespace std;


int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n, m;
		cin >> n >> m;
		char arr[5][5];
		string x, y = "";
		for (int i = 0; i < n; i++) {
			string s;
			cin >> s;
			if (i == 0) x = s;
			for (int j = 0; j < m; j++) {
				arr[i][j] = s[j];
				if (arr[0][0] == '0') {
					if (j == 0) {
						y += s[j];
					}
				}
				else {
					if (j == 0) {
						if (s[j] == '0') y += '1';
						else y += '0';
					}
				}
			}
		}
		bool chk = true;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (x[i] == '0' && y[j] == '0') {
					if (arr[j][i] != '0') {
						chk = false;
						break;
					}
				}
				if (x[i] == '0' && y[j] == '1') {
					if (arr[j][i] != '1') {
						chk = false;
						break;
					}
				}
				if (x[i] == '1' && y[j] == '0') {
					if (arr[j][i] != '1') {
						chk = false;
						break;
					}
				}
				if (x[i] == '1' && y[j] == '1') {
					if (arr[j][i] != '0') {
						chk = false;
						break;
					}
				}
			}
		}
		
		if (chk)
			cout << "#" << t << " " << "yes" << "\n";
		else cout << "#" << t << " " << "no" << "\n";

	}
}