#include <iostream>
using namespace std;

long long gcd(long long a, long long b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}

long long lcm(long long a, long long b) {
	return (a * b) / gcd(a, b);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	long long a, b, c, d;
	cin >> a >> b;
	cin >> c >> d;
	long long frac = lcm(b, d);
	long long temp1 = frac / b;
	long long temp2 = frac / d;
	int sum = a * temp1 + c * temp2;
	int g = gcd(sum, frac);
	cout << sum / g << " " << frac / g;

}