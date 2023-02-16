#include <iostream>
using namespace std;

int main() {
	int n, k, v;
	int num[31] = { 0 };
	for (int i = 0; i < 28; i++) {
		cin >> k;
		num[k]++;
	}
	for (int i = 1; i <= 30; i++) {
		if (num[i] == 0)
			cout << i << endl;
	}
}