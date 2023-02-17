#include <iostream>
using namespace std;

int main() {
	int a, max = 0;
	int n, m;
	int arr[9][9] = { 0 };
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> a;
			arr[i][j] = a;
			if (max <= a) {
				n = i;
				m = j;
				max = a;
			}
		}
	}
	cout << max << endl << n + 1 << " " << m + 1;
}