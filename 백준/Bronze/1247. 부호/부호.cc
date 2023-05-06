#include <iostream>
#include <climits>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	long long n;
	for (int i = 0; i < 3; i++) {
		cin >> n;
		long long sum = 0, overflow = 0;
		long long tmp;
		for (int j = 0; j < n; j++) {
			cin >> tmp;
			if (sum > 0 && tmp > 0 && tmp > LLONG_MAX - sum)
				overflow++;
			if (sum < 0 && tmp < 0 && tmp < LLONG_MIN - sum)
				overflow--;

			sum += tmp;
		}
		if (overflow > 0) cout << "+\n";
		else if (overflow < 0) cout << "-\n";
		else if (sum > 0) cout << "+\n";
		else if (sum == 0) cout << "0\n";
		else cout << "-\n";
	}
}