#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

#define INF 99999999

vector<pair<int, int>> v[2001];
vector<int> dest;
int Dist_S[2001];
int Dist_G[2001];
int Dist_H[2001];

void Initialize() {
	for (int i = 0; i < 2001; i++) {
		v[i].clear();
		Dist_S[i] = INF;
		Dist_G[i] = INF;
		Dist_H[i] = INF;
	}
	dest.clear();
}

void dijkstra(int s, int dist[]) {
	priority_queue<pair<int, int>> pq;
	pq.push({ 0,s });
	dist[s] = 0;

	while (!pq.empty()) {
		int cost = pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i].first;
			int nCost = v[cur][i].second;

			if (dist[next] > cost + nCost) {
				dist[next] = cost + nCost;
				pq.push({ dist[next],next });
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int T;
	cin >> T;
	int n, m, t, s, g, h, a, b, d, x;
	while (T--) {
		Initialize();

		cin >> n >> m >> t;
		cin >> s >> g >> h;
		for (int i = 0; i < m; i++) {
			cin >> a >> b >> d;
			v[a].push_back({ b,d });
			v[b].push_back({ a,d });
		}
		while (t--) {
			cin >> x;
			dest.push_back(x);
		}

		dijkstra(s, Dist_S);
		dijkstra(g, Dist_G);
		dijkstra(h, Dist_H);

		sort(dest.begin(), dest.end());
		for (int i = 0; i < dest.size(); i++) {
			if (Dist_S[dest[i]] == Dist_S[g] + Dist_G[h] + Dist_H[dest[i]]) cout << dest[i] << " ";
			else if (Dist_S[dest[i]] == Dist_S[h] + Dist_G[h] + Dist_G[dest[i]]) cout << dest[i] << " ";
		}
		cout << "\n";
	}
}