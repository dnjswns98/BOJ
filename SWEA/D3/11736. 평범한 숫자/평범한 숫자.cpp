#include <iostream>
using namespace std;

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		int arr[20];
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}

		int cnt = 0;
		for (int i = 1; i <= n - 2; i++) {
			if (arr[i] > arr[i - 1] && arr[i] < arr[i + 1]) cnt++;
			else if (arr[i] < arr[i - 1] && arr[i] > arr[i + 1]) cnt++;
		}

		cout << "#" << t << " " << cnt << '\n';
	}
}