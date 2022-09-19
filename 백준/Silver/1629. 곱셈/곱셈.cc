#include <iostream>
using namespace std;

#define ll long long

ll mul(ll a, ll b, ll c) {
	if (b == 1)
		return a % c;
	if (b % 2 == 0) {
		ll tmp = mul(a, b / 2, c);
		return tmp * tmp % c;
	}
	return a * mul(a, b - 1, c) % c;
}

int main() {
	ll x, y, z;
	cin >> x >> y >> z;
	cout << mul(x, y, z);
}