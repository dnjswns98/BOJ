#include <iostream>
#include <string>
#include <cmath>
using namespace std;


int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n, ans;
		cin >> n;
		int x = n + 1, y = 1;
		while (1) {
			bool check1 = false;
			for (int i = 2; i <= sqrt(x); i++) {
				if (x % i == 0) {
					check1 = true;
					break;
				}
			}
			bool check2 = false;
			for (int i = 2; i <= sqrt(y); i++) {
				if (y % i == 0) {
					check2 = true;
					break;
				}
			}
			if (check1 && check2) {
				break;
			}
			x++;
			y++;
		}

		cout << "#" << t << " " << x << " " << y << "\n";


	}
}