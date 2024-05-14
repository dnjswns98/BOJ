#include <iostream>

using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		int ans = n / 3;
		cout << "#" << t << " " << ans << '\n';
	}
}