#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, b;
	cin >> n >> b;
	vector<int> v;
	while (true) {
		v.push_back(n % b);
		n /= b;
		if (n == 0) break;
	}
	char c;
	for (auto i = v.rbegin(); i < v.rend(); i++) {
		if (*i > 9) {
			c = *i + 'A' - 10;
			cout << c;
		}
		else {
			cout << *i;
		}
	}
}