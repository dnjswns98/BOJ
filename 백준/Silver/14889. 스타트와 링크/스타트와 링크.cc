#include <iostream>
#include <cmath>
using namespace std;
#define max 21

int n;
int ans = 10000000;
int arr[max][max];
bool check[max];

void dfs(int cnt, int idx) { //count와 인덱스를 넘긴다.
	if (cnt == n / 2) {
		int S_result = 0, R_result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (check[i] == true && check[j] == true)
					S_result += arr[i][j];
				if (check[i] == false && check[j] == false)
					R_result += arr[i][j];
			}
		}
		if (ans > abs(S_result - R_result)) 
			ans = abs(S_result - R_result);
		
		return;
	}
	for (int i = idx; i < n; i++) {
		check[i] = true;
		dfs(cnt + 1, i + 1);
		check[i] = false;
	}
}

int main() {
	cin >> n;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			cin >> arr[i][j];

	dfs(0, 1);
	cout << ans;
}