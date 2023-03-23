#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int a, b, c;
	cin >> a >> b >> c;
	int sum = a + b + c;
	if (a == 60 && b == 60 && c == 60) cout << "Equilateral";
	else if (sum == 180) {
		if (a == b || b == c || a == c) cout << "Isosceles";
		else if (a != b && b != c && a != c) cout << "Scalene";
	}
	else cout << "Error";
}