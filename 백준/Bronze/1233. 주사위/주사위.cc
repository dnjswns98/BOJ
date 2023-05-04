#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int a, b, c;
	cin >> a >> b >> c;
	int arr1[20];
	int arr2[20];
	int arr3[40];
	for (int i = 0; i < a; i++) {
		arr1[i] = i + 1;
	}
	for (int i = 0; i < b; i++) {
		arr2[i] = i + 1;
	}
	for (int i = 0; i < c; i++) {
		arr3[i] = i + 1;
	}
	int cnt[80] = { 0 };
	for (int i = 0; i < a; i++) {
		for (int j = 0; j < b; j++) {
			int sum = arr1[i] + arr2[j];
			for (int k = 0; k < c; k++) {
				int sum = arr1[i] + arr2[j] + arr3[k];
				cnt[sum]++;
			}
		}
	}
	int max = 0;
	int idx;
	for (int i = 0; i < 80; i++) {
		if (cnt[i] > max) {
			max = cnt[i];
			idx = i;
		}
	}
	cout << idx;
}