#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n, m;
		cin >> n >> m;

		char arr[50][50];
		queue<pair<int, int>> q;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cin >> arr[i][j];
				if (arr[i][j] != '?') q.push(make_pair(i, j));
			}
		}
		if (q.empty()) {
			cout << "#" << t << " " << "possible" << '\n';
			continue;
		}

		bool chk = true;
		int check[50][50] = { 0 };
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();
			check[y][x] = 1;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (check[ny][nx]) continue;

				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (arr[y][x] == '#') {
						if (arr[ny][nx] == '#') {
							chk = false;
							break;
						}
						else if (arr[ny][nx] == '?') {
							arr[ny][nx] = '.';
							q.push(make_pair(ny, nx));
						}
					}
					else if(arr[y][x] == '.') {
						if (arr[ny][nx] == '.') {
							chk = false;
							break;
						}
						else if (arr[ny][nx] == '?') {
							arr[ny][nx] = '#';
							q.push(make_pair(ny, nx));
						}
					}
				}
			}

			if (!chk) break;
		}
		if(chk) cout << "#" << t << " " << "possible" << '\n';
		else cout << "#" << t << " " << "impossible" << '\n';
	}
}