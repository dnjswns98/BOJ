#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	int n;
	cin >> n;
	cout << 1 << " ";
	int ans = 1;
	for (int i = 1; i <= n; i++) {
		ans *= 2;
		cout << ans << " ";
	}
}