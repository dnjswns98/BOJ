#include <iostream>
#include <vector>
using namespace std;

#define INF 999999999

vector<pair<int, int>> v[501];
long long dist[501];
int n, m, a, b, c;
bool check = false;

void Bellman_Ford() {
	dist[1] = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			for(int k = 0; k<v[j].size(); k++){
				int next = v[j][k].first;
				int nCost = v[j][k].second;

				if (dist[j] == INF) continue;
				if (dist[next] > dist[j] + nCost) {
					dist[next] = dist[j] + nCost;

					if (i == n) check = true;
				}
			}
		}
	}

	if (!check) {
		for (int i = 2; i <= n; i++) {
			if (dist[i] == INF) cout << -1 << "\n";
			else cout << dist[i] << "\n";
		}
	}
	else cout << -1;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		dist[i] = INF;
	}
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
	}
	Bellman_Ford();
}