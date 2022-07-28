#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
	int n, num, cnt = 0;
	cin >> n;
	vector<int> x;
	for (int i = 0; i < n; i++) {
		cin >> num;
		x.push_back(num);
	}
	vector<int> copy_x = { x.begin(),x.end() };
	sort(copy_x.begin(), copy_x.end());
	copy_x.erase(unique(copy_x.begin(), copy_x.end()), copy_x.end());

	for (int i = 0; i < n; i++) {
		auto index = lower_bound(copy_x.begin(), copy_x.end(), x[i]) - copy_x.begin();
		x[i] = index;
	}

	/*for (int i = 0; i < copy_x.size(); i++) {
		for (int j = 0; j < n; j++) {
			if (copy_x[i] == x[j]) {
				x[j] = cnt;
			}
		}
		cnt++;
	}*/

	for (int i = 0; i < n; i++) {
		cout << x[i] << " ";
	}
}