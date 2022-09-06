#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int m, n;
int arr[101][101] = { 0 };
int dist[101][101] = { 0 };
bool visited[101][101] = { false };
int px[4] = { 1,0,-1,0 };
int py[4] = { 0,1,0,-1 };
int cnt = 0;

void Input() {
	cin >> n >> m;
	string s;
	for (int i = 1; i <= n; i++) {
		cin >> s;
		for (int j = 1; j <= m; j++) {
			arr[i][j] = s[j - 1] - '0';
		}
	}
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	dist[x][y] = 1;
	visited[x][y] = true;
	while (!q.empty()) {
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = cx + px[i];
			int ny = cy + py[i];
			if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && arr[nx][ny] == 1 && !visited[nx][ny]) {
				dist[nx][ny] = dist[cx][cy] + 1;
				visited[nx][ny] = true;
				q.push(make_pair(nx, ny));
			}
		}
	}
}

void solve() {
	Input();
	bfs(1, 1);
	cout << dist[n][m];
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	solve();
}