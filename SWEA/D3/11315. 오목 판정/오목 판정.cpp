#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int dx[] = { 1,0,-1,0,1,-1,1,-1 };
int dy[] = { 0,-1,0,1,1,1,-1,-1 };

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		char arr[20][20];
		queue<pair<int, int>> q;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
				if (arr[i][j] == 'o') q.push(make_pair(i, j));
			}
		}

		bool chk = false;
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();

			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				int cnt = 1;
				while (1) {
					if (ny < 0 || nx < 0 || ny >= n || nx >= n) break;
					if (arr[ny][nx] != 'o') break;
					cnt++;
					if (cnt >= 5) {
						chk = true;
						break;
					}

					ny += dy[i];
					nx += dx[i];
				}
			}

			if (chk) break;
		}

		if (chk)
			cout << "#" << t << " " << "YES" << '\n';
		else cout << "#" << t << " " << "NO" << '\n';
	}
}