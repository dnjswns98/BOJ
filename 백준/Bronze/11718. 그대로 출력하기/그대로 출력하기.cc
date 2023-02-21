#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int i = 100;
	string str;
	while (i > 0) {
		getline(cin, str);
		cout << str << "\n";
		i--;
	}
}