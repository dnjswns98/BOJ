#include <iostream>
#include <string>
using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i * i + j * j <= n * n) {
					ans++;
				}
			}
		}
		ans *= 4;
		ans += n * 4;
		ans++;

		cout << "#" << t << " " << ans << "\n";


	}
}