#include <iostream>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	string str[10] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
	string s;
	int tmp[3];
	for (int i = 0; i < 3; i++) {
		cin >> s;
		for (int j = 0; j < 10; j++) {
			if (str[j] == s) {
				tmp[i] = j;
				break;
			}
		}
	}
	long long res = tmp[0] * 10 + tmp[1];
	res = res * pow(10, tmp[2]);
	cout << res;
}