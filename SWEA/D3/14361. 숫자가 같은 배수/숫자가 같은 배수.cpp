#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s;
		cin >> s;
		int s_cnt[10] = { 0 };
		for (int i = 0; i < s.size(); i++) {
			s_cnt[s[i] - '0']++;
		}
		bool chk = true;
		int n = stoi(s);
		int k = 2;
		while (1) {
			int num = n * k;
			string str = to_string(num);
			if (s.size() < str.size()) {
				chk = false;
				break;
			}
			
			int str_cnt[10] = { 0 };
			for (int i = 0; i < str.size(); i++) {
				str_cnt[str[i] - '0']++;
			}

			bool equal = true;
			for (int i = 0; i < 10; i++) {
				if (s_cnt[i] != str_cnt[i]) {
					equal = false;
					break;
				}
			}

			if (equal) {
				break;
			}
			k++;
		}

		if(chk) cout << "#" << t << " " << "possible" << '\n';
		else cout << "#" << t << " " << "impossible" << '\n';
	}
}