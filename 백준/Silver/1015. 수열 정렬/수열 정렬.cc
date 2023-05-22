#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

#define INF 999999999

int a[50];
int b[50];
bool visited[50] = { false };
vector<int> ans;
int n;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		b[i] = a[i];
	}
	sort(b, b + n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i] == b[j] && !visited[j]) {
				visited[j] = 1;
				ans.push_back(j);
				break;
			}
		}
	}
	for (auto iter = ans.begin(); iter != ans.end(); iter++) {
		cout << *iter << " ";
	}
}