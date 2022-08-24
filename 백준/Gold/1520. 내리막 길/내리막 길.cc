#include <iostream>
using namespace std;

//참고 : https://gusdnr69.tistory.com/76

int arr[500][500] = { 0 };
int dp[500][500];
int x_arr[4] = { 1, 0, -1, 0 };
int y_arr[4] = { 0, 1, 0, -1 };
int m, n;

int dfs(int y, int x) {
	if (y == m - 1 && x == n - 1) //종점
		return 1;
	if (dp[y][x] != -1) //이미 방문한 곳
		return dp[y][x];

	dp[y][x] = 0;
	for (int i = 0; i < 4; i++) { //현재위치에서 4방면중에 작은 값을 가진 곳 찾기
		int x_next = x + x_arr[i];
		int y_next = y + y_arr[i];

		if (y_next >= 0 && x_next >= 0 && y_next < m && x_next < n)
			if (arr[y_next][x_next] < arr[y][x])
				dp[y][x] += dfs(y_next, x_next);
	}
	return dp[y][x];
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> m >> n;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
			dp[i][j] = -1;
		}
	}
	cout << dfs(0, 0);
}