#include <iostream>
#include <vector>

using namespace std;
typedef unsigned long long ull;

vector<int> arr;
int n;
ull m;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;

	arr.assign(m, 0);

	ull cur;
	ull sum = 0;
	ull ans = 0;

	for (int i = 0; i < n; i++) {
		cin >> cur;
		sum += cur;
		
		ans += arr[sum % m]++;
	}

	cout << ans + arr[0];	// 나머지가 0인 집합들은 혼자만 있어도 가능하므로
}