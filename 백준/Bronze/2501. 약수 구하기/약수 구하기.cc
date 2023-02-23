#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, k;
	int cnt = 0;
	cin >> n >> k;
	for (int i = 1; i <= n; i++) {
		if (n % i == 0)
			cnt++;
		if (cnt == k) {
			cout << i;
			return 0;
		}
		if(i == n && cnt < k){
			cout << 0;
			return 0;
		}
	}
}