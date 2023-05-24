#include <iostream>
#include <algorithm>
using namespace std;

vector<pair<int, int>> v;
int n, m;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> m;
	int a, b;
	int set = 1000, one = 1000;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		set = min(set, a);
		one = min(one, b);
	}
	if (set >= one * 6)
		cout << n * one;
	else if (set < one * 6) {
		if (n / 6 * set + n % 6 * one < (n / 6 + 1) * set)
			cout << n / 6 * set + n % 6 * one;
		else
			cout << (n / 6 + 1) * set;
	}
}