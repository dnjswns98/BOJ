#include <iostream>
#include <cmath>

using namespace std;

int w[30] = { 0 };
int bead[7] = { 0 };
int dp[31][15001] = { 0 };
int m, n;

void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> w[i];
	}
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> bead[i];
	}
}

void make_balance(int i, int weight) {
	if (i > n) return;
	if (dp[i][weight]) return;
	dp[i][weight] = 1;

	make_balance(i + 1, weight + w[i]); //저울의 같은 곳에 추를 추가
	make_balance(i + 1, weight); //저울에 추를 올리지 않음
	make_balance(i + 1, abs(weight - w[i])); //저울의 양쪽에 추를 넣음
}

void solution() {
	make_balance(0, 0);
	for (int i = 0; i < m; i++) {
		if (bead[i] > 15000) cout << "N ";
		else if (dp[n][bead[i]] != 0) cout << "Y ";
		else cout << "N ";
	}
}

void solve() {
	input();
	solution();
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	solve();
}