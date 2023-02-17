#include <iostream>
using namespace std;

int main() {
	int n, m, a;
	cin >> n >> m;
	int arrA[100][100] = { 0 };
	int arrB[100][100] = { 0 };
	int sum[100][100] = { 0 };
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a;
			arrA[i][j] = a;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a;
			arrB[i][j] = a;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			sum[i][j] = arrA[i][j] + arrB[i][j];
			cout << sum[i][j] << " ";
		}
		cout << endl;
	}
}