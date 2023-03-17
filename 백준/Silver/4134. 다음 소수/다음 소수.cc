#include <iostream>
#include <algorithm>
using namespace std;

bool isPrime(long long a) {
	if (a == 0 || a == 1) return false;
    if (a == 2) return true;
	if (a % 2 == 0) return false;

	for (long long i = 3; i * i <= a; i++) {
		if (a % i == 0) return false;
	}
	return true;
}

long long prime(long long a) {
	while (1) {
		bool check = isPrime(a);
		if (check) break;
		a++;
	}
	return a;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;
	long long tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		cout << prime(tmp) << "\n";
	}
}