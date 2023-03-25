#include <iostream>
#include <vector>
using namespace std;

vector<int> v[501];
bool visited[501];

bool dfs(int x, int post_x) {
	visited[x] = true;

	for (int i = 0; i < v[x].size(); i++) {
		int next = v[x][i];
		if (next == post_x) continue;
		if (visited[next]) return false;
		if (!dfs(next, x)) return false;
	}
	return true;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	int caseidx = 0;

	while (1) {

		cin >> n >> m;
		if (n == 0 && m == 0) return 0;
		
		caseidx++;
		for (int i = 1; i < 501; i++) {
			v[i].clear();
			visited[i] = false;
		}

		int a, b;
		for (int i = 0; i < m; i++) {
			cin >> a >> b;
			v[a].push_back(b);
			v[b].push_back(a);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				if (dfs(i, 0)) cnt++;
		}

		if (cnt == 0) cout << "Case " << caseidx << ": No trees.\n";
		else if (cnt == 1) cout << "Case " << caseidx << ": There is one tree.\n";
		else if (cnt >= 2) cout << "Case " << caseidx << ": A forest of " << cnt << " trees.\n";
	}

	
	
}