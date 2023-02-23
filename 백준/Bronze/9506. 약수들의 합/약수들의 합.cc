#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	vector<int> v;
	while (true) {
		int sum = 0;
		cin >> n;

		if (n == -1) return 0;

		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				v.push_back(i);
				sum += i;
			}
		}

		if (sum == n) {
			cout << n << " = ";
			for (int i = 0; i < v.size(); i++) {
				if (i == v.size() - 1) {
					cout << v[i] << "\n";
					break;
				}
				cout << v[i] << " + ";
			}
		}
		else {
			cout << n << " is NOT perfect.\n";
		}

		v.clear();
	}
}