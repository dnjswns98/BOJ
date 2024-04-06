#include <iostream>
#include <stack>
using namespace std;

int main(void)
{
	int n;
	cin >> n;
	
	string s;
	int cnt = 0;
	while (n--) {
		cin >> s;
		stack<char> st;

		for (int i = 0; i < s.size(); i++) {
			if (st.empty()) {
				st.push(s[i]);
			}
			else {
				if (st.top() == s[i]) {
					st.pop();
				}
				else {
					st.push(s[i]);
				}
			}
		}

		if (st.empty()) cnt++;
	}
	cout << cnt;
}