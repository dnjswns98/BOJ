#include<iostream>
#include <string>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{	
		string s;
		cin >> s;

		string ans = "";
		for (int i = s.size(); i >= 0; i--) {
			if (s[i] == 'b') {
				ans += 'd';
			}
			else if (s[i] == 'd') {
				ans += 'b';
			}
			else if (s[i] == 'p') {
				ans += 'q';
			}
			else if (s[i] == 'q') {
				ans += 'p';
			}
		}

		cout << "#" << test_case << " " << ans << "\n";
	}

	return 0;
}