#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n, m;
	cin >> n >> m;
	char c[50][50];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> c[i][j];
		}
	}

	int rowCheck = 0;
	for (int i = 0; i < n; i++) {
		bool check = true;
		for (int j = 0; j < m; j++) {
			if (c[i][j] == 'X') {
				check = false;
				break;
			}
		}
		if (check) rowCheck++;
	}

	int colCheck = 0;
	for (int i = 0; i < m; i++) {
		bool check = true;
		for (int j = 0; j < n; j++) {
			if (c[j][i] == 'X') {
				check = false;
				break;
			}
		}
		if (check) colCheck++;
	}
	cout << max(rowCheck, colCheck) << endl;
}