#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> v[100001];
bool visited[100001];
int result = 0;
int endnode;

void dfs(int r, int len) {
	if (visited[r]) return;
	visited[r] = true;

	if (result < len) {
		result = len;
		endnode = r;
	}

	for (int i = 0; i < v[r].size(); i++) {
		dfs(v[r][i].first, len + v[r][i].second);
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;

	int a, b, c;
	for (int i = 0; i < n; i++) {
		cin >> a;
		while (true)
		{
			cin >> b;
			if (b == -1) break;
			cin >> c;
			v[a].push_back(make_pair(b, c));
			v[b].push_back(make_pair(a, c));
		}
	}
	dfs(1, 0);

	result = 0;
	fill_n(visited, sizeof(visited), false);
	dfs(endnode, 0);
	cout << result;
}