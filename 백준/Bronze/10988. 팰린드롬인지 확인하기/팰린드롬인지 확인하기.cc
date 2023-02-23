#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string str;
	cin >> str;
	int n = str.length() - 1;
	for (int i = 0; i < str.length() / 2; i++) {
		if (str[i] != str[n]) {
			cout << "0";
			return 0;
		}
		n--;
	}
	cout << "1";
}