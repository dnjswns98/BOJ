#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

int n, k;
vector<int> v;

bool search(ll mid) {
	ll cnt = 0;
	for (int i = 0; i < n; i++) {
		cnt += v[i] / mid;
	}
	if (cnt >= k)
		return true;
	else return false;
}

void solve() {
	ll left = 1; //최소값
	ll right = v[n - 1]; //최대값
	ll midMax = 0;
	while (left <= right) {
		ll mid = (left + right) / 2;
		bool found = search(mid);
		if (found) {
			midMax = max(midMax, mid);
			left = mid + 1;
		}
		else
			right = mid - 1;
	}
	cout << midMax;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	
	solve();
}