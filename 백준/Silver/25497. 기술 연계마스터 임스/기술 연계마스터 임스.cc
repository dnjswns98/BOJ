#include <iostream>
#include <stack>
using namespace std;

int main(void)
{
	int n;
	string s;
	cin >> n >> s;
	
	stack<char> Lst;
	stack<char> Sst;
	int cnt = 0;
	
	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= '1' && s[i] <= '9')
			cnt++;
		else {
			if (s[i] == 'L') Lst.push(s[i]);
			else if (s[i] == 'S') Sst.push(s[i]);
			else if (s[i] == 'R') {
				if (!Lst.empty()) {
					cnt++;
					Lst.pop();
				}
				else break;
			}
			else {
				if (!Sst.empty()) {
					cnt++;
					Sst.pop();
				}
				else break;
			}
		}
	}
	cout << cnt;
}