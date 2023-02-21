#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, m;
	int i, j;
	int arr[101] = { 0 };
	cin >> n >> m;
	for (int h = 1; h <= n; h++) {
		arr[h] = h;
	}
	for (int h = 0; h < m; h++) {
		cin >> i >> j;
		for (int k = 0; k <= (j - i) / 2; k++) {
			int temp = arr[k + i];
			arr[k + i] = arr[j - k];
			arr[j - k] = temp;
		}
	}
	for (int h = 1; h <= n; h++) {
		cout << arr[h] << " ";
	}
}