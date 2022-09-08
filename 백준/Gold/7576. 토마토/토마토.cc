#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int m, n;
int arr[1001][1001] = { 0 };
int cnt[1001][1001] = { 0 };
int px[4] = { 1,0,-1,0 };
int py[4] = { 0,1,0,-1 };
queue<pair<int, int>> q;

void Input() {
	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 1)
				q.push(make_pair(i, j));
		}
	}
}

void bfs() {
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = px[i] + x;
			int ny = py[i] + y;
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
				q.push(make_pair(nx, ny));
				arr[nx][ny] = 1;
				cnt[nx][ny] = cnt[x][y] + 1;
			}
		}
	}
}

void Output() {
	int num = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 0) {
				cout << "-1";
				return;
			}
			num = max(num, cnt[i][j]);
		}
	}
	cout << num;
}

void solve() {
	Input();
	bfs();
	Output();
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	solve();
}