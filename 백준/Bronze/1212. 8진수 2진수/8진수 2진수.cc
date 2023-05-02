#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string s;
	cin >> s;
	if (s == "0") {
		cout << 0;
		return 0;
	}
	string str = "";
	for (int i = 0; i < s.size(); i++) {
		str += to_string((s[i] - '0') / 4);
		str += to_string(((s[i] - '0') % 4) / 2);
		str += to_string(((s[i] - '0') % 4) % 2);
	}
	bool check = false;
	for (int i = 0; i < str.size(); i++) {
		if (!check) {
			if (str[i] == '1') {
				check = true;
				cout << str[i];
			}
		}
		else {
			cout << str[i];
		}
	}

}