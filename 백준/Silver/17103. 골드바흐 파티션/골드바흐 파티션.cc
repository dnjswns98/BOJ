#include <iostream>
using namespace std;
#define max 1000001

int arr[max] = { 0 };

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	for (int i = 2; i < max; i++) {
		arr[i] = i;
	}
	for (int i = 2; i * i < max; i++) {
		if (arr[i] == 0) continue;
		for (int j = i * i; j < max; j += i) {
			arr[j] = 0;
		}
	}

	int n;
	cin >> n;
	int tmp;
	for (int i = 0; i < n; i++) {
		int cnt = 0;
		cin >> tmp;
		
		for (int i = 2; i <= tmp / 2; i++) {
			if (arr[i] + arr[tmp - i] == tmp) cnt++;
		}
		cout << cnt << "\n";
	}
}