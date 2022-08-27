#include <iostream>

using namespace std;

int num[100] = { 0 };
int dp[100001] = { 0 };
int n, k;

//10을 1로 만들 수 있는 경우의 수는 1
//10을 2로 만들 수 있는 경우의 수는 5
// 8을 2로 만들 수 있는 경우의 수는 4
// 여기에 2를 한번 넣으면 되므로 8을 만드는 경우의 수 + 1 = 10을 2로 만들 수 있는 경우의 수

void input() {
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
}

void solution() {
	dp[0] = 1; //아무것도 고르지 않은 경우의 수
	for (int i = 0; i < n; i++) { //각각의 동전 사용
		for (int j = num[i]; j <= k; j++) {
			dp[j] += dp[j - num[i]];
		}
	}
	cout << dp[k];
}

void solve() {
	input();
	solution();
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	solve();
}