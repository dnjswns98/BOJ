#include <iostream>
#include <stack>
using namespace std;

int arr[1001] = {};

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	int n;
	cin >> n;
	int l, h, rightl = 0, maxl = 0, maxh = 0;
	int res = 0;
	for (int i = 0; i < n; i++) {
		cin >> l >> h;
		if (maxh < h) {
			maxh = h;
			maxl = l;
		}
		arr[l] = h;
		if (rightl < l) rightl = l;
	}

	int left = 0, right = 0;
	for (int i = 1; i < maxl; i++) {
		if (left < arr[i]) {
			left = arr[i];
		}
		res += left;
	}

	for (int i = rightl; i > maxl; i--) {
		if (right < arr[i]) {
			right = arr[i];
		}
		res += right;
	}

	cout << res + maxh;
}