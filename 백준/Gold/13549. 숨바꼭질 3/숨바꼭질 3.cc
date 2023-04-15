#include <iostream>
#include <queue>
using namespace std;

bool visited[100001];
int n, k;

int dijkstra() {


	priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, n });
    visited[n] = true;

	while (!pq.empty()) {
		int time = pq.top().first;
		int x = pq.top().second;

        pq.pop();

		if (x == k) return time;

		if (x * 2 < 100001 && !visited[x * 2]) {
			pq.push({ time, x * 2 });
			visited[x * 2] = true;
		}

		if (x + 1 < 100001 && !visited[x + 1]) {
			pq.push({ time + 1, x + 1 });
			visited[x + 1] = true;
		}

		if (!visited[x - 1] && x - 1 >= 0) {
			pq.push({ time + 1, x - 1 });
			visited[x - 1] = true;
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> k;

	cout << dijkstra();

}