#include <iostream>
using namespace std;
#define max 11

int n, result;
int nMax = -1000000000;
int nMin = 1000000000;
int arr[max];
int op[4];

void dfs(int result, int x) {
	if (x == n - 1) {
		if (nMax < result)
			nMax = result;
		if (nMin > result)
			nMin = result;
		return;
	}
	for (int i = 0; i < 4; i++) {
		if (op[i] > 0) {
			op[i]--;
			if (i == 0) {
				dfs(result + arr[x + 1], x + 1);
			}
			else if (i == 1) {
				dfs(result - arr[x + 1], x + 1);
			}
			else if (i == 2) {
				dfs(result * arr[x + 1], x + 1);
			}
			else {
				dfs(result / arr[x + 1], x + 1);
			}
			op[i]++;
		}
	}
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	for (int i = 0; i < 4; i++)
		cin >> op[i];
	dfs(arr[0], 0);
	cout << nMax << "\n" << nMin;
}