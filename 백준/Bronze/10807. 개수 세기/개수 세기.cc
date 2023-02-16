#include <iostream>
using namespace std;

int main() {
	int n, k, v;
	int num[201] = { 0 };
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		num[k + 100]++;
	}
	cin >> v;
	cout << num[v + 100];
}