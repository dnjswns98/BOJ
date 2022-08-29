#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m, r;
vector<int> v[100001];
bool visited[100001] = { false };
int result[100001];
int cnt = 0;

bool compare(int a, int b) {
	return a > b;
}

void dfs(int x) {
	queue<int> q;
	q.push(x);

	visited[x] = true;
	cnt++;
	result[x] = cnt;
	
	while (!q.empty()) {
		int frontq = q.front();
		q.pop();

		for (int i = 0; i < v[frontq].size(); i++) {
			int tmp = v[frontq][i];
			if (visited[tmp]) continue;
			q.push(tmp);
			visited[tmp] = true;
			cnt++;
			result[tmp] = cnt;
		}
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