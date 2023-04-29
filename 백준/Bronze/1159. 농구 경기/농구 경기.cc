#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	cin >> n;
	int alpha[26] = { 0 };
	vector<string> v;
	string s;
	for (int i = 0; i < n; i++) {
		cin >> s;
		alpha[s[0] - 97]++;
	}
	bool check = false;
	for (int i = 0; i < 26; i++) {
		if (alpha[i] >= 5) check = true;
	}
	if (check) {
		for (int i = 0; i < 26; i++) {
			if (alpha[i] >= 5) cout << char(i + 97);
		}
	}
	else cout << "PREDAJA";
}