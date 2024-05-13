#include <iostream>
#include <string>
#include <cmath>
using namespace std;


int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		long long n, ans;
		cin >> n;
		for (int i = sqrt(n); i >= 1; i--) {
			if (n % i == 0) {
				ans = (i - 1) + (n / i - 1);
				break;
			}
		}
		cout << "#" << t << " " << ans << "\n";


	}
}