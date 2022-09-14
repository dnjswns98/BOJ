#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
int arr[101] = { 0 };
bool visited[101] = { false };

void input() {
	cin >> n >> m;
	int a, b;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		arr[a] = b;
	}
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		arr[a] = b;
	}
}

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	while (!q.empty()) {
		int cur = q.front().first;
		int cnt = q.front().second;
		q.pop();
		for (int i = 1; i <= 6; i++) {
			int next = cur + i;
			if (next == 100) {
				cout << cnt + 1;
				return;
			}
			else if (next < 100) {
				while (arr[next] != 0) {
					next = arr[next];
				}
				if (!visited[next]) {
					q.push(make_pair(next, cnt + 1));
					visited[next] = true;
				}
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0);
	
	input();
	bfs(1, 0);
}