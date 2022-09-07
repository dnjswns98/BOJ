#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
#define MAX 26

int n, k;
bool visited[100001] = { false };

void Input() {
	cin >> n >> k;
}

void bfs(int x) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, 0));
	visited[x] = true;
	while (!q.empty()) {
		int cx = q.front().first;
		int cnt = q.front().second;
		q.pop();

		if (cx == k) {
			cout << cnt << "\n";
			break;
		}
		if (cx + 1 >= 0 && cx + 1 < 100001 && !visited[cx + 1]) {
			visited[cx + 1] = true;
			q.push(make_pair(cx + 1, cnt + 1));
		}
		if (cx - 1 >= 0 && cx - 1 < 100001 && !visited[cx - 1]) {
			visited[cx - 1] = true;
			q.push(make_pair(cx - 1, cnt + 1));
		}
		if (cx * 2 >= 0 && cx * 2 < 100001 && !visited[cx * 2]) {
			visited[cx * 2] = true;
			q.push(make_pair(cx * 2, cnt + 1));
		}
	}
}

void solution() {
	Input();
	bfs(n);
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0);
	
	solution();
}