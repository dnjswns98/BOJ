#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int gcd(int a, int b) {
	int n = max(a, b);
	int m = min(a, b);

	while (n % m != 0) {
		int p = n % m;
		n = m;
		m = p;
	}
	return m;
}

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		string s1, s2;
		cin >> s1 >> s2;

		int size1 = s1.size();
		int size2 = s2.size();

		int pro = gcd(size1, size2);
		pro = size1 * size2 / pro;

		string ans1 = "", ans2 = "";
		for (int i = 1; i <= pro / size1; i++) {
			ans1 += s1;
		}
		for (int i = 1; i <= pro / size2; i++) {
			ans2 += s2;
		}

		if (ans1 == ans2) {
			cout << "#" << t << " " << "yes" << "\n";
		}
		else {
			cout << "#" << t << " " << "no" << "\n";
		}

	}
}