#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int tmp;
		cin >> tmp;
		cout << binary_search(v.begin(), v.end(), tmp) << "\n";
	}
}