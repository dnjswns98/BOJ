#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;

#define INF 999999999

int dist[1001];
int pre[1001] = { 0 };
vector<pair<int,int>> v[1001];
int n, m;
int a, b, c, s, e;

void dijkstra() {
	priority_queue<pair<int, int>> q;
	q.push({ 0,s });
	dist[s] = 0;

	while (!q.empty()) {
		int cost = q.top().first;
		int cur = q.top().second;
		q.pop();

		if (dist[cur] < cost) continue;

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i].first;
			int n_cost = v[cur][i].second;

			if (dist[next] > cost + n_cost) {
				dist[next] = cost + n_cost;
				q.push({ dist[next],next });
				pre[next] = cur;
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		dist[i] = INF;

	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
	}
	cin >> s >> e;

	dijkstra();

	cout << dist[e] << "\n";
	stack<int> ans;
	ans.push(e);
	while (pre[e] != 0) {
		ans.push(pre[e]);
		e = pre[e];
	}
	cout << ans.size() << "\n";
	while (!ans.empty()) {
		cout << ans.top() << " ";
		ans.pop();
	}
}