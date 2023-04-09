#include <iostream>
#include <cmath>
using namespace std;

void cal(int n) {
	int size = pow(3, n);

	if (n == 0) {
		cout << "-";
		return;
	}

	cal(n - 1);
	for (int i = 0; i < size / 3; i++) {
		cout << " ";
	}
	cal(n - 1);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	int n;
	while (cin >> n) {
		cal(n);
		cout << "\n";
	}
	
}