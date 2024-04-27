#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	stack<char> st;
	string s;
	cin >> s;
	int sum = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(') {
			st.push(s[i]);
		}
		else {
			if (s[i - 1] == '(') {
				st.pop();
				sum += st.size();
			}
			else {
				st.pop();
				sum++;
			}
		}
	}
	cout << sum;
}