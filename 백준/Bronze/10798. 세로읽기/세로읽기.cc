#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string str[5];
	for (int i = 0; i < 5; i++) {
		cin >> str[i];
	}
	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 5; j++) {
			if(i < str[j].length())
				cout << str[j][i];
		}
	}
}