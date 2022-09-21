#include <iostream>
#include <vector>
using namespace std;

int t, n, m;
vector<vector<int>> v;
vector<int> visited;

void Input() {
	cin >> n >> m;
	v.assign(n + 1, vector<int>(0, 0));
	visited.assign(n + 1, 0);
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		v[a].emplace_back(b);
		v[b].emplace_back(a);
	}
}

void dfs(int cur) {
	if (visited[cur] == 0) visited[cur] = 1;

	for (int i = 0; i < v[cur].size(); i++) {
		int next = v[cur][i];

		if (!visited[next]) {
			if (visited[cur] == 1) visited[next] = 2;
			if (visited[cur] == 2) visited[next] = 1;
			dfs(next);
		}
	}
}

bool graph() {
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < v[i].size(); j++) {
			int next = v[i][j];
			if (visited[i] == visited[next])
				return false;
		}
	}
	return true;
}

int main() {
	cin >> t;
	while (t--) {
		Input();
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) dfs(i);
		}
		if (graph())
			cout << "YES\n";
		else
			cout << "NO\n";
	}
}