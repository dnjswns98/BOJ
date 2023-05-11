#include <iostream>
#include <algorithm>
using namespace std;

#define INF 999999999

int dist[401][401];
int n, m, a, b, c;

void floydWarshall() {
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] > dist[i][k] + dist[k][j])
					dist[i][j] = dist[i][k] + dist[k][j];
			}
		}
	}

	int result = INF;
	for (int i = 1; i <= n; i++) {
		result = min(result, dist[i][i]);
	}

	cout << ((result == INF) ? -1 : result);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			dist[i][j] = INF;
		}
	}
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		dist[a][b] = c;
	}
	floydWarshall();
}