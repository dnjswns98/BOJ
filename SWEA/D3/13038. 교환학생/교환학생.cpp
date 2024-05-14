#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int main(void) {

	int test;
	cin >> test;

	for (int t = 1; t <= test; t++) {
		int n;
		cin >> n;
		int arr[7];
		queue<int> q;
		for (int i = 0; i < 7; i++) {
			cin >> arr[i];
			if (arr[i] == 1) q.push(i);
		}

		int ans = 999999999;
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int first = q.front();
			q.pop();
			int cnt = 0;
			int day = 0;
			while (n != cnt) {
				if (arr[first] == 1) cnt++;
				day++;
				first++;
				if (first == 7) first = 0;
			}
			ans = min(ans, day);
		}

		cout << "#" << t << " " << ans << '\n';
	}
}