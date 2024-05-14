#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n, m, a, b;
		cin >> n >> m >> a >> b;
		int A = min(m, b);
		int B = max(n, a);
		int ans;
		if (A - B < 0) ans = 0;
		else ans = A - B;
		cout << "#" << t << " " <<  ans << '\n';
	}
}