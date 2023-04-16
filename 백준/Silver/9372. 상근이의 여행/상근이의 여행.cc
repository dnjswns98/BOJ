#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<int> v[1001];
bool visited[1001];
int ans;

void bfs(int start) {
	visited[start] = true;
	queue<int> q;
	q.push(start);

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (int i = 0; i < v[x].size(); i++) {
			int next = v[x][i];
			if (!visited[next]) {
				visited[next] = true;
				ans++;
				q.push(next);
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int t, a, b;
	int n, m;
	cin >> t;
	while (t--) {
		cin >> n >> m;
		for (int i = 1; i <= n; i++) {
			v[i].clear();
			visited[i] = false;
		}
		for (int i = 0; i < m; i++) {
			cin >> a >> b;
			v[a].push_back(b);
			v[b].push_back(a);
		}
		ans = 0;
		bfs(1);
		cout << ans << "\n";
	}

}