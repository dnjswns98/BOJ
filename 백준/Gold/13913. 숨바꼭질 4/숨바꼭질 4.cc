#include <iostream>
#include <queue>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

bool visited[100001] = { false };
int n, k;
int cnt = 0;
vector<int> mem(100001);
stack<int> ans;

void bfs() {
	queue<pair<int, int>> q;
	q.push({ n,0 });
	visited[n] = true;


	while (!q.empty()) {
		int x = q.front().first;
		int time = q.front().second;
		q.pop();

		if (x == k) {
			cout << time << "\n";
			ans.push(x);
			
			for (int i = 0; i < time; i++) {
				ans.push(mem[x]);
				x = mem[x];
			}

			while (!ans.empty()) {
				cout << ans.top() << " ";
				ans.pop();
			}
			break;
		}

		if (x + 1 <= 100000 && visited[x + 1] == false) {
			visited[x + 1] = true;
			q.push({ x + 1,time + 1 });
			mem[x + 1] = x;
		}
		if (x - 1 >= 0 && visited[x - 1] == false) {
			visited[x - 1] = true;
			q.push({ x - 1,time + 1 });
			mem[x - 1] = x;
		}
		if (x * 2 <= 100000 && visited[x * 2] == false) {
			visited[x * 2] = true;
			q.push({ x * 2,time + 1 });
			mem[x * 2] = x;
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin >> n >> k;

	bfs();
}