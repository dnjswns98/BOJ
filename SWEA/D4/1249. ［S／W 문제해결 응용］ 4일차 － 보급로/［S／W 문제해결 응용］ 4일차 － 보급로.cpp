#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int arr[100][100];
int dp[100][100];
int visited[100][100];
int n;

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };

void init() {
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			arr[i][j] = 0;
			dp[i][j] = 0;
			visited[i][j] = 0;
		}
	}
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	visited[0][0] = 1;

	while (!q.empty()) {
		int cx = q.front().second;
		int cy = q.front().first;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (visited[ny][nx] != 1 || dp[ny][nx] > dp[cy][cx] + arr[cy][cx]) {
					dp[ny][nx] = dp[cy][cx] + arr[cy][cx];
					q.push(make_pair(ny, nx));
					visited[ny][nx] = 1;
				}
			}
		}
	}
}

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		cin >> n;

		init();

		for (int i = 0; i < n; i++) {
			string s;
			cin >> s;
			for (int j = 0; j < n; j++) {
				arr[i][j] = s[j] - '0';
			}
		}

		bfs(0, 0);

		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cout << dp[i][j];

			}
			cout << '\n';
		}*/

		cout << "#" << t << " " << dp[n - 1][n - 1] << "\n";
	}
}