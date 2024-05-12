#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		stack<int> s;

		for (int i = 0; i < 3; i++) {
			int num;
			cin >> num;
			s.push(num);
		}
		int t = s.top();
		s.pop();
		int cnt = 0;
		while (!s.empty()) {

			if (s.top() == 0) {
				break;
			}

			if (s.top() >= t) {
				s.top()--;
				cnt++;
			}
			else {
				t = s.top();
				s.pop();
			}

		}

		if (!s.empty() && s.top() == 0) {
			cout << "#" << test_case << " " << -1 << "\n";
			continue;
		}
		cout << "#" << test_case << " " << cnt << "\n";
	}
}