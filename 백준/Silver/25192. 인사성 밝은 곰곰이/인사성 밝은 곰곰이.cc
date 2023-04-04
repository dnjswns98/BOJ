#include <iostream>
#include <set>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;

	set<string> s;
	string str;
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		cin >> str;
		if (str == "ENTER") {
			cnt += s.size();
			s.clear();
		}
		else s.insert(str);
	}
	cnt += s.size();
	cout << cnt << "\n";
}