#include <iostream>
#include <string>
#include <vector>
using namespace std;

string ans = "abcdefghijklmnopqrstuvwxyz";

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s;
		cin >> s;
		int cnt = 0;

		for (int i = 0; i < s.size(); i++) {
			if (ans[i] != s[i]) break;
			cnt++;
		}
		

		cout << "#" << t << " " << cnt << "\n";


	}
}