#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int cnt[1000001];
int num[1000001];

int dp(int x){
	cnt[1] = 0;
	num[1] = 0;

	for (int i = 2; i <= x; i++) {
		cnt[i] = cnt[i - 1] + 1;
		num[i] = i - 1;

		if (i % 3 == 0) {
			if (cnt[i] > cnt[i / 3] + 1) {
				cnt[i] = cnt[i / 3] + 1;
				num[i] = i / 3;
			}
		}

		if (i % 2 == 0) {
			if (cnt[i] > cnt[i / 2] + 1) {
				cnt[i] = cnt[i / 2] + 1;
				num[i] = i / 2;
			}
		}
	}

	return cnt[x];
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin >> n;

	cout << dp(n) << "\n";

	while (n != 0) {
		cout << n << " ";
		n = num[n];
	}
}