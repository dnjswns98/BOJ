#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;
	int cnt = 0;
	for (int i = 1; i * i <= n; i++) {
		cnt++;
	}
	cout << cnt;
}