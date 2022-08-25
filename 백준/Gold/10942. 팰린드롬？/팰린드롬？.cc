#include <iostream>

using namespace std;

int arr[2001] = { 0 };
int dp[2001][2001] = { 0 };
int m, n, s, e;

void solve() {
	for (int i = 2; i <= n - 1; i++) { //구간의 길이
		for (int j = 1; i + j <= n; j++) { //시작하는 부분
			if (dp[j + 1][i + j - 1] != 0 && arr[j] == arr[i + j])
				dp[j][i + j] = 1;
		}
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		dp[i][i] = 1; //한자릿수는 무조건 팰린드롬

		if (i != 1 && arr[i] == arr[i - 1]) //11,22,33과 같이 두자릿수
			dp[i - 1][i] = 1;
	}
	solve();
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> s >> e;
		cout << dp[s][e] << "\n";
	}
}