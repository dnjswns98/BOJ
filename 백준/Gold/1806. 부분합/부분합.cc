#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, s;
	cin >> n >> s;
	vector<int> v;
	vector<int> dist;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	int start = 0, end = 0;
	int sum = 0;
	int ans = 0;
	queue<int> q;
	while (1) {
		if (end == n && sum < s) break;

		if (sum >= s) {
			dist.push_back(q.size());
			sum -= v[q.front()];
			q.pop();
		}
		else if (end < n && sum + v[end] < s) {
			q.push(end);
			sum += v[end++];
		}
		else if (end < n && sum + v[end] >= s) {
			q.push(end);
			sum += v[end++];
			dist.push_back(q.size());
			sum -= v[q.front()];
			q.pop();
		}
	}

	if (dist.size() == 0) cout << 0;
	else {
		int min = 100000000;
		for (auto iter = dist.begin(); iter != dist.end(); iter++) {
			if (min > *iter)
				min = *iter;
		}
		cout << min;
	}
}