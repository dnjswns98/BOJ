#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

int n, c;
vector<int> v;

bool search(int mid) {
	int start = v[0];
	int cnt = 1;
	for (int i = 1; i < n; i++) {
		if (v[i] - start >= mid) {
			cnt++;
			start = v[i];
		}
	}
	if (cnt >= c)
		return true;
	else return false;
}

void solve() {
	int left = 0; //최소값
	int right = v[n - 1]; //최대값
	int midMax = 0;
	while (left <= right) {
		int mid = (left + right) / 2;
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

	cin >> n >> c;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	
	solve();
}