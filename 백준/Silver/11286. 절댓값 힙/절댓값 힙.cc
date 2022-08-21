#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct compare {
	bool operator()(pair<int, int>a, pair<int, int>b) {
		if (a.second == b.second) {
			return a.first > b.first;
		}
		return a.second > b.second;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	priority_queue<pair<int,int>,vector<pair<int,int>>, compare> q;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		if (tmp > 0) {
			q.push(make_pair(tmp,tmp));
		}
		else if (tmp < 0) {
			q.push(make_pair(tmp, -tmp));
		}
		else {
			if (q.empty())
				cout << "0\n";
			else {
				cout << q.top().first << "\n";
				q.pop();
			}
		}
	}
}