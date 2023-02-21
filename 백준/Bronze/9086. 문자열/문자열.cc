#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int t;
	cin >> t;
	string str;
	for (int i = 0; i < t; i++) {
		cin >> str;
		cout << str[0] << str[str.length() - 1] << "\n";
	}
}