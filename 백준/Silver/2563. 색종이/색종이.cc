#include <iostream>
using namespace std;

int main() {
	int n, a, b;
	int arr[101][101] = { 0 };
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		for (int j = a; j < a + 10; j++) {
			for (int h = b; h < b + 10; h++) {
				arr[j][h] = 1;
			}
		}
	}

	int cnt = 0;
	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			if (arr[i][j] == 1)
				cnt++;
		}
	}

	cout << cnt;
}