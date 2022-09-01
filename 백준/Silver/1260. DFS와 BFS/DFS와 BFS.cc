#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m, r;
vector<int> v[1001];
bool dfs_visited[1001] = { false };
vector<int> dfs_result;
bool bfs_visited[1001] = { false };
vector<int> bfs_result;

void dfs(int x) {
	if (dfs_visited[x]) return;
	dfs_visited[x] = true;
	dfs_result.push_back(x);
	for (int i = 0; i < v[x].size(); i++) {
		dfs(v[x][i]);
	}
}

void bfs(int x) {
	queue<int> q;
	q.push(x);
	bfs_visited[x] = true;
	bfs_result.push_back(x);
	while (!q.empty()) {
		int frontq = q.front();
		q.pop();
		for (int i = 0; i < v[frontq].size(); i++) {
			int tmp = v[frontq][i];
			if (bfs_visited[tmp]) continue;
			q.push(tmp);
			bfs_visited[tmp] = true;
			bfs_result.push_back(tmp);
		}
	}
}

void print() {
	for (int i = 0; i < dfs_result.size(); i++) {
		cout << dfs_result[i] << " ";
	}
	cout << "\n";
	for (int i = 0; i < bfs_result.size(); i++) {
		cout << bfs_result[i] << " ";
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> r;
	int tmp1, tmp2;
	for (int i = 0; i < m; i++) {
		cin >> tmp1 >> tmp2;
		v[tmp1].push_back(tmp2);
		v[tmp2].push_back(tmp1);
	}
	for (int i = 1; i <= n; i++) {
		sort(v[i].begin(), v[i].end());
	}
	dfs(r);
	bfs(r);
	print();
}