#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	char tmp;
	int cnt = 0;
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			cin >> tmp;
			if (i % 2 == 0 && j % 2 == 0 && tmp == 'F') cnt++;
			else if (i % 2 == 1 && j % 2 == 1 && tmp == 'F') cnt++;
		}
	}
	cout << cnt;
}