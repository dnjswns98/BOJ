#include <iostream>
#include <vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int b;
	string s;
	cin >> s >> b;
	int size = s.size();
	int sum = 0;
	for (int i = size - 1; i >= 0; i--) {
		int num = s[i];
		if (num >= 'A') num = num - 'A' + 10;
		else num = num - '0';

		int ex = 1;
		for (int j = i + 1; j < size; j++) {
			ex *= b;
		}
		sum += num * ex;
	}
	cout << sum;
}