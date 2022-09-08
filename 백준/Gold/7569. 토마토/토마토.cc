#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int m, n, h;
int arr[101][101][101] = { 0 };
int cnt[101][101][101] = { 0 };
int px[] = { 1,0,-1,0,0,0 };
int py[] = { 0,1,0,-1,0,0 };
int pz[] = { 0,0,0,0,1,-1 };

typedef struct tomato {
	int x, y, z;
} tomato;

queue<tomato> q;

void Input() {
	cin >> m >> n >> h;
	for (int k = 0; k < h; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cin >> arr[i][j][k];
				if (arr[i][j][k] == 1)
					q.push({ i, j, k });
			}
		}
	}
}

void bfs() {
	while (!q.empty()) {
		int cx = q.front().x;
		int cy = q.front().y;
		int cz = q.front().z;
		q.pop();

		for (int i = 0; i < 6; i++) {
			int nx = px[i] + cx;
			int ny = py[i] + cy;
			int nz = pz[i] + cz;
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && arr[nx][ny][nz] == 0) {
				q.push({ nx, ny, nz });
				arr[nx][ny][nz] = 1;
				cnt[nx][ny][nz] = cnt[cx][cy][cz] + 1;
			}
		}
	}
}

void Output() {
	int num = 0;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (arr[j][k][i] == 0) {
					cout << "-1";
					return;
				}
				num = max(num, cnt[j][k][i]);
			}
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