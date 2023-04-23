#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
    cin >> n;
	vector<string> v;
	for(int i = 1;  i<= n; i++) {
		string s;
		cin >> s;
		v.push_back(s);

	}
	string s = "";
	for (int i = 0; i < v[0].size(); i++) {
		s += v[0][i];
		for (int j = 1; j < n; j++) {
			if (s[i] != v[j][i]) {
				s[i] = '?';
				break;
			}
		}
	}
	cout << s;
}