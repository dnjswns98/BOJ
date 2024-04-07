#include <iostream>
#include <stack>
using namespace std;

int main(void)
{
	int n, m;
	cin >> n;
	
	stack<int> s;
	for (int i = 0; i < n; i++) {
		cin >> m;
		s.push(m);
	}

	int cnt = 0;
	int max = 0;
	while(!s.empty()) {
		if (max < s.top()) {
			max = s.top();
			cnt++;
		}
		s.pop();
	}
	cout << cnt;
}