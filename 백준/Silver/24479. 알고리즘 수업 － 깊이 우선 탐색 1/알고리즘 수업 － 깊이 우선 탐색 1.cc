#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, r;
vector<int> v[100001];
bool visited[100001] = { false };
int result[100001];
int cnt = 0;

void dfs(int x) {
	if (visited[x]) return;
	visited[x] = true;
	cnt++;
	result[x] = cnt;
	for (int i = 0; i < v[x].size(); i++) {
		dfs(v[x][i]);
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m >> r;
	int tmp1, tmp2;
	for (int i = 1; i <= m; i++) {
		cin >> tmp1 >> tmp2;
		v[tmp1].push_back(tmp2);
		v[tmp2].push_back(tmp1);
	}
	for (int i = 1; i <= n; i++) {
		sort(v[i].begin(), v[i].end());
	}
	dfs(r);
	for (int i = 1; i <= n; i++) {
		cout << result[i] << "\n";
	}
}