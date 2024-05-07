#include <iostream>
#include <string>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);



	string s;
	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		int a = s[i] - 64;
		cout << a << " ";
	}

}