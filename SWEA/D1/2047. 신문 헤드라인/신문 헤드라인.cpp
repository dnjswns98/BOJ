#include <iostream>
#include <string>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);



	string s;
	cin >> s;
	string ans = "";
	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 'a' && s[i] <= 'z') {
			ans += s[i] - 32;
		}
		else ans += s[i];
	}
	cout << ans;
}