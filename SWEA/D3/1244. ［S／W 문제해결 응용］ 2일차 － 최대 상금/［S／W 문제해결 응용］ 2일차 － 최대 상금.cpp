#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string s;
int n;
int ans = 0;

void dfs(int start, int cnt) {
	if (s.size() == 1) {
		ans = stoi(s);
		return;
	}

	if (cnt == n) {
		ans = max(ans, stoi(s));
		return;
	}

	for (int i = start; i < s.size() - 1; i++) {
		for (int j = i + 1; j < s.size(); j++) {
			if (s[i] <= s[j]) {
				swap(s[i], s[j]);
				dfs(i, cnt + 1);
				swap(s[i], s[j]);
			}
			if (i == s.size() - 2 && j == s.size() - 1) {
				swap(s[i], s[j]);
				dfs(i, cnt + 1);
				swap(s[i], s[j]);
			}
		}
	}
}

int main(void) {

	ios::sync_with_stdio;
	cin.tie(0); cout.tie(0);

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		cin >> s >> n;
		
		ans = 0;
		dfs(0, 0);

		cout << "#" << t << " " << ans << "\n";
	}
}