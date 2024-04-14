#include <iostream>
#include <stack>
using namespace std;

int main(void)
{
	int n;
	string s;
	cin >> s;
	
	stack<char> st;
	int cnt = 0;
	
	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(') {
			st.push(s[i]);
		}
		else {
			if (st.empty()) {
				cnt++;
			}
			else {
				st.pop();
			}
		}
	}
	cnt += st.size();
	cout << cnt;
}