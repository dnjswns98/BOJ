#include <iostream>
#include <queue>
#include <vector>
using namespace std;

#define INF 1000000000
vector<pair<int, int>> v[20001];
int dist[20001];
int n, e, start;

//struct compare {
//	bool operator()(pair<int, int>a, pair<int, int>b) {
//		return a.second < b.second;
//	}
//};

void dijkstra() {

	dist[start] = 0;

	priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, start });

	while (!pq.empty()) {
		int cost = pq.top().first;
		int now = pq.top().second;

        pq.pop();


        if (dist[now] < cost) {
            continue;
        }


        for (int i = 0; i < v[now].size(); ++i) {


            int next_destination = v[now][i].second;

            int next_distance = cost + v[now][i].first;


            if (dist[next_destination] > next_distance) {
                dist[next_destination] = next_distance;


                pq.push(make_pair(next_distance, next_destination));
            }
        }
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n >> e >> start;

	for (int i = 1; i <= n; i++)
		dist[i] = INF;

	int a, b, c;
	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		v[a].push_back({ c,b });
	}

	dijkstra();

	for (int i = 1; i <= n; i++) {
		if (dist[i] == INF) cout << "INF\n";
		else cout << dist[i] << "\n";
	}
}