#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	int arr[5];
	for (int i = 0; i < 5; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + 5);
	int num = arr[2];
	while (1) {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (num % arr[i] == 0) {
				cnt++;
			}
		}
		if (cnt >= 3) break;
		num++;
	}
	cout << num;
}