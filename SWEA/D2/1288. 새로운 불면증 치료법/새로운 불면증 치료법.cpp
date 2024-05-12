#include <iostream>
#include <string>
#include <set>
using namespace std;

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		cin >> n;
		set<char> s;
		int cnt = 1;
		int temp = n;
		while (1) {
			string str = to_string(n);
			for (int i = 0; i < str.size(); i++) {
				s.insert(str[i]);
			}
			if (s.size() == 10) break;
			cnt++;
			n = temp * cnt;
		}

		cout << "#" << test_case << " " << n << "\n";
	}
}