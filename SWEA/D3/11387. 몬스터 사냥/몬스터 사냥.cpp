#include <iostream>
#include <string>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int d, l, n;
		cin >> d >> l >> n;
		long long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += d/100 * (100 + i * l);
		}

		cout << "#" << t << " " << sum << '\n';
	}
}