#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	int n;
	cin >> n;
	int m, a, t;
	stack<pair<int, int>> s;
	int sum = 0;
	while (n--) {
		cin >> m;
		if (m == 1) {
			cin >> a >> t;
			s.push(make_pair(a, t));
		}
		if (!s.empty()) {
			s.top().second--;
			if (s.top().second == 0) {
				sum += s.top().first;
				s.pop();
			}
		}
	}
	cout << sum;
}