#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define MAX 26

int n, cnt = 0;
string s;
int arr[MAX][MAX] = { 0 };
bool visited[MAX][MAX] = { false };
vector<int> result;
int cx[4] = { 1, 0, -1, 0 };
int cy[4] = { 0, 1, 0, -1 };

void Input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s;
		for (int j = 0; j < n; j++) {
			arr[i][j] = s[j] - '0';
		}
	}
}

void dfs(int x, int y) {
	cnt++;
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int next_x = cx[i] + x;
		int next_y = cy[i] + y;
		if ((next_x >= 0 && next_y >= 0 && next_x < n && next_y < n) && !visited[next_x][next_y] && arr[next_x][next_y] == 1) {
			dfs(next_x, next_y);
		}
	}
}

void solution() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 1 && !visited[i][j]) {
				cnt = 0;
				dfs(i, j);
				result.push_back(cnt);
			}
		}
	}
}

void output() {
	cout << result.size() << "\n";
    sort(result.begin(), result.end());
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << "\n";
	}
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0);
	
	Input();
	solution();
	output();
}