#include <iostream>
#include <string>
using namespace std;

int main(void) {
	string a;
	getline(cin, a);
	string key;
	cin >> key;
	char cy[30001] = { NULL };
	for (int i = 0; i < a.length(); i++) {
		if (a[i] == ' ')
			cy[i] = ' ';
		else if ((int)a[i] - (int)key[i%key.length()] <= 0)
			cy[i] = (char)((int)a[i] - (int)key[i%key.length()] + 122);
		else
			cy[i] = (char)((int)a[i] - (int)key[i%key.length()] + 96);
	}
	cout << cy << endl;
	return 0;
}