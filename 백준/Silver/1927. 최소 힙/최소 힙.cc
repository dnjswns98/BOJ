#include <iostream>
#include <queue>
using namespace std;

int n;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	int tmp;
	priority_queue<int,vector<int>,greater<>> q;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		if (tmp > 0) {
			q.push(tmp);
		}
		else {
			if (q.empty())
				cout << "0\n";
			else {
				cout << q.top() << "\n";
				q.pop();
			}
		}
	}
}