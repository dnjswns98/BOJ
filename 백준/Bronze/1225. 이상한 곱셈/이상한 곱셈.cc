#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string s1, s2;
	cin >> s1 >> s2;
	long long sum = 0;
	for (int i = 0; i < s1.size(); i++) {
		int a = s1[i] - '0';
		for (int j = 0; j < s2.size(); j++) {
			int b = s2[j] - '0';
			sum += a * b;
		}
	}
	cout << sum;

}