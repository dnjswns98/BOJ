#include <iostream>
#include <algorithm>
using namespace std;

#define INF 999999999

int a[50];
int b[50];
int n;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> b[i];
	}
	sort(a, a + n);
	sort(b, b + n, greater<>());
	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum += a[i] * b[i];
	}
	cout << sum;
}