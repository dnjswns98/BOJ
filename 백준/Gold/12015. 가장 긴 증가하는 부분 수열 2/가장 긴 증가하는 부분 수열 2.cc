#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

int n;
vector<int> ans;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;

		if (ans.empty() || ans.back() < tmp)
			ans.push_back(tmp);
		else {
			*(lower_bound(ans.begin(), ans.end(), tmp)) = tmp;
		}
	}
	cout << ans.size();
}