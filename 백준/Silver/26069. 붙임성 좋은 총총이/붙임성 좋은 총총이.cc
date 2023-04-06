#include <iostream>
#include <map>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	int n;
	cin >> n;

	map<string, bool> m;
	string str1, str2;
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		cin >> str1 >> str2;
		m.insert({ str1, false });
		m.insert({ str2, false });
		
		if (str1 == "ChongChong") m[str2] = true;
		else if (str2 == "ChongChong") m[str1] = true;

		if (m[str1] && !m[str2]) m[str2] = true;
		else if (!m[str1] && m[str2]) m[str1] = true;
	}
	for (auto iter = m.begin(); iter != m.end(); iter++) {
		if (iter->second) cnt++;
	}
	cout << cnt;
}