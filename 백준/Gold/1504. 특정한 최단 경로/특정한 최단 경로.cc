#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

#define INF 1000000000

vector<pair<int, int>> v[801];
int n, e;
int dist[801];

void dijkstra(int start) {

	for (int i = 1; i <= n; i++)
		dist[i] = INF;

	priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, start });
	dist[start] = 0;

	while (!pq.empty()) {
		int cost = pq.top().first;
		int now = pq.top().second;

        pq.pop();

		if (dist[now] < cost)
			continue;

		for (int i = 0; i < v[now].size(); i++) {
			int next_cost = cost + v[now][i].second;
			int next_dest = v[now][i].first;

			if (next_cost < dist[next_dest]) {
				dist[next_dest] = next_cost;

				pq.push({ next_cost, next_dest });
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> e;
	int a, b, c;
	int v1, v2;
	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
		v[b].push_back({ a,c });
	}
	cin >> v1 >> v2;

	dijkstra(1);
	int sTOv1 = dist[v1];
	int sTOv2 = dist[v2];

	dijkstra(v1);
	int v1TOv2 = dist[v2];
	int v1TOn = dist[n];

	dijkstra(v2);
	int v2TOn = dist[n];

	int result = min(sTOv1 + v1TOv2 + v2TOn, sTOv2 + v1TOv2 + v1TOn);

	if (v1TOv2 == INF || result >= INF) cout << -1;
	else cout << result;
}