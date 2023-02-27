#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	long long n, cnt = 0;
	cin >> n;
	for (long long i = 1; i <= n - 2; i++) {
		cnt += i * (i + 1) / 2;
	}
	cout << cnt << "\n" << "3";
}