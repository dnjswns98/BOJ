#include <iostream>
#include <cmath>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		int a, b;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			cin >> a >> b;
			int xy = a * a + b * b;
			for (int j = 20; j <= 200; j+=20) {
				if (xy <= j*j) {
					ans += 11 - j / 20;
					break;
				}
			}
		}

		cout << "#" << t << " " <<  ans << '\n';
	}
}