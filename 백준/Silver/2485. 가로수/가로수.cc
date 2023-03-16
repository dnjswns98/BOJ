#include <iostream>
#include <algorithm>
using namespace std;

long long gcd(long long a, long long b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	int tree[100000];
	int dis[100000] = { 0 };
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tree[i];
	}
	sort(tree, tree + n);

	for (int i = 0; i < n - 1; i++) {
		dis[i] = tree[i + 1] - tree[i];
	}

	int num = dis[0];
	for (int i = 1; i < n - 1; i++) {
		num = gcd(dis[i], num);
	}
	int result = 0;
	for (int i = 0; i < n - 1; i++) {
		result += dis[i] / num - 1;
	}
	cout << result;
}