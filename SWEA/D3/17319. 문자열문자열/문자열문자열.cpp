#include <iostream>
#include <string>
using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		string s;
		cin >> s;
		int len = s.size();
		if (len >= 2) {
			string str1 = s.substr(0, len / 2);
			string str2 = s.substr(len/2);

			if (str1 == str2)
				cout << "#" << t << " " << "Yes" << "\n";
			else cout << "#" << t << " " << "No" << "\n";
		}
		else {
			cout << "#" << t << " " << "No" << "\n";
		}

	}
}