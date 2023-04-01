#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;
	int point = 2;
	for (int i = 0; i < n; i++) {
		point = point * 2 - 1;
	}
	cout << point * point;
}