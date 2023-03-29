#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, c;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> c;
		int q = c / 25;
		int d = (c % 25) / 10;
		int nickel = (c - (q * 25 + d * 10)) / 5;
		int p = c - (q * 25 + d * 10 + nickel * 5);
		cout << q << " " << d << " " << nickel << " " << p << "\n";
	}
	
}