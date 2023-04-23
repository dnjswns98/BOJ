#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int f;
	string s;
    cin >> s >> f;
	int size = s.size();
	string temp = "";
	for (int i = 0; i < size - 2; i++) {
		temp += s[i];
	}
	temp += "00";
	int num = stoi(temp);
	//cout << num;
	for (int i = num; i <= num + 100; i++) {
		if (i % f == 0) {
			if(i - num < 10)
				cout << 0 << i - num;
			else cout << i - num;
			break;
		}
	}
}