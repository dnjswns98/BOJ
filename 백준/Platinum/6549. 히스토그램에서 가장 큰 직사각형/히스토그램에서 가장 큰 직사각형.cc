#include<iostream>
#include<stack>
#include<algorithm>
using namespace std;
using ll = long long;
#define size 100002
ll n;
ll h[size] = { 0 };

void input() {
	for (int i = 1; i <= n; i++) {
		cin >> h[i];
	}
}

ll area() {
	stack<int> s;
	ll result = 0;
	s.push(0);
	for (int i = 1; i <= n + 1; i++) { //n번째값을 처리해줘야하기때문에 0값이 들어있는 n+1까지
		while (!s.empty() && h[s.top()] > h[i])
		{
			int height, weight;

			height = s.top();
			s.pop();

			weight = i - s.top() - 1;

			result = max(result, h[height] * weight);
		}
		s.push(i);
	}
	return result;
}

void init() {
	for (int i = 1; i <= n; i++) {
		h[i] = 0;
	}
}

int main() {
	while (1) 
	{
		cin >> n;
		if (n <= 0)
			return 0;
		input();
		cout << area() << "\n";
		init();
	}
}