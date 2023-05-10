#include <iostream>
#include <vector>
using namespace std;

#define INF 999999999

int dist[101][101];
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

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (dist[i][j] == INF) cout << 0 << " ";
			else cout << dist[i][j] << " ";
		}
		cout << "\n";
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			dist[i][j] = INF;
			if (i == j) dist[i][j] = 0;
		}
	}
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		if (dist[a][b] > c) 
			dist[a][b] = c;
	}
	floydWarshall();
}