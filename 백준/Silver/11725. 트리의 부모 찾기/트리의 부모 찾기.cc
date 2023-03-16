#include <iostream>
#include <vector>

using namespace std;

int result[100001];
bool visited[100001];
vector<int> v[100001];

void dfs(int r) {
	if (!visited[r])
		visited[r] = true;
	for (int i = 0; i < v[r].size(); i++) {
		int next = v[r][i];
		if (!visited[next]) {
			visited[next] = true;
			result[next] = r;
			dfs(next);
		}
	}
}

int main() {
	int n;
	cin >> n;
	int a, b;

	for (int i = 0; i < n - 1; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	dfs(1);

	for (int i = 2; i <= n; i++)
		cout << result[i] << "\n";
}