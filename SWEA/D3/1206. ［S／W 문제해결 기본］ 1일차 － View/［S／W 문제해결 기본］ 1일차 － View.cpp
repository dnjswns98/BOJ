#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000];

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test = 10;
	//cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		
		int sum = 0;
		for (int i = 2; i < n - 2; i++) {
			sum += max(0, arr[i] - max(max(arr[i - 1], arr[i - 2]), max(arr[i + 1], arr[i + 2])));
		}

		cout << "#" << t << " " << sum << "\n";
	}
}