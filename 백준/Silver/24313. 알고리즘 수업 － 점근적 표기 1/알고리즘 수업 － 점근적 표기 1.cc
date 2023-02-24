#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int a1, a, c, n;
	cin >> a1 >> a >> c >> n;
	if ((a1 * n + a) <= c * n && a1 <= c) {
		cout << "1";
		return 0;
	}
	cout << "0";
}