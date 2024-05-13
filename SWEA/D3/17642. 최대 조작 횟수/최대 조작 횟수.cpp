#include <iostream>
#include <cmath>
using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		long long a, b, ans = 0;
		cin >> a >> b;
		if (a == b) {
			ans = 0;
		}
		else if (a > b) ans = -1;
		else if (abs(a - b) == 1) ans = -1;
		else {
			long long num = abs(a - b);
			if (num % 2 == 0) {
				ans = num / 2;
			}
			else {
				num -= 3;
				ans = num / 2;
				ans++;
			}
		}
		cout << "#" << t << " " << ans << "\n";
	}
}