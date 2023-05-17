#include <iostream>
#include <list>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n;
	string s;
	cin >> s;
	cin >> n;
	char c;
	list<char> l;
	for (int i = 0; i < s.size(); i++) {
		l.push_back(s[i]);
	}
	auto iter = l.end();
	for (int i = 0; i < n; i++) {
		cin >> c;
		if (c == 'L') {
			if (iter != l.begin())
				iter--;
		}
		else if (c == 'D') {
			if (iter != l.end())
				iter++;
		}
		else if (c == 'B') {
			if (iter != l.begin()) {
				iter--;
				iter = l.erase(iter);
			}
		}
		else if (c == 'P') {
			char tmp;
			cin >> tmp;
			l.insert(iter, tmp);
		}
	}

	for (auto it = l.begin(); it != l.end(); it++) {
		cout << *it;
	}
}