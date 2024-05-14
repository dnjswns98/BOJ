#include <iostream>
#include <algorithm>
using namespace std;


int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		char arr[20][20];
		int minx = 20, miny = 20, maxx = 0, maxy = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
				if (arr[i][j] == '#') {
					minx = min(minx, j);
					miny = min(miny, i);
					maxx = max(maxx, j);
					maxy = max(maxy, i);
				}
			}
		}
		bool chk = true;
		int cntx = maxx - minx;
		int cnty = maxy - miny;
		for (int i = miny; i <= maxy; i++) {
			for (int j = minx; j <= maxx; j++) {
				if (arr[i][j] != '#') {
					chk = false;
					break;

				}
			}
			if (!chk) break;
		}

		if (chk && cntx == cnty) cout << "#" << t << " yes" << '\n';
		else cout << "#" << t << " no" << '\n';

	}
}