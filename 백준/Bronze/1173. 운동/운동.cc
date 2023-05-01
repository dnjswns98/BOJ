#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int n,m,M,T,R;
	cin >> n >> m >> M >> T >> R;
	int min = 0;
	int cnt = 0;
	int sum = m;
	if (m + T > M) {
		cout << -1;
		return 0;
	}
	while (min < n) {
		if (sum + T <= M) {
			sum += T;
			min++;
		}
		else {
			if (sum - R >= m)
				sum -= R;
			else sum = m;
		}
		cnt++;
	}
	cout << cnt;
}