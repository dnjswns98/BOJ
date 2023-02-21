#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, m;
	int i, j, k;
	int arr[101] = { 0 };
	cin >> n >> m;
	for (int h = 1; h <= n; h++) {
		arr[h] = h;
	}
	for (int h = 0; h < m; h++) {
		cin >> i >> j;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	for (int h = 1; h <= n; h++) {
		cout << arr[h] << " ";
	}
}