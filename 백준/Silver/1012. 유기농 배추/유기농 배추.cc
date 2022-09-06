#include <iostream>
#include <cstring>
using namespace std;

int t, m, n, k;
int arr[50][50] = { 0 };
bool visited[50][50] = { false };
int cx[4] = { 1,0,-1,0 };
int cy[4] = { 0,1,0,-1 };

void dfs(int x, int y) {
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int next_x = cx[i] + x;
		int next_y = cy[i] + y;
		if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < m && arr[next_x][next_y] == 1 && !visited[next_x][next_y])
			dfs(next_x, next_y);
	}
}

void Input() {
	cin >> t;
	int tmp1, tmp2;
	while(t--) {
		int cnt = 0;
		cin >> m >> n >> k;
		for (int i = 0; i < k; i++) {
			cin >> tmp1 >> tmp2;
			arr[tmp2][tmp1] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		cout << cnt << "\n";
		memset(arr, 0, sizeof(arr));
		memset(visited, false, sizeof(visited));
	}
}

void solve() {
	Input();
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	solve();
}