#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m;
vector<int> v[101];
bool visited[101] = { false };
int cnt = 0;

bool compare(int a, int b) {
	return a > b;
}

void dfs(int x) {
	if (x > n) return;
	if (visited[x]) return;
	cnt++;
	visited[x] = true;
	for (int i = 0; i < v[x].size(); i++) {
		dfs(v[x][i]);
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	int tmp1, tmp2;
	for (int i = 0; i < m; i++) {
		cin >> tmp1 >> tmp2;
		v[tmp1].push_back(tmp2);
        v[tmp2].push_back(tmp1);
	}
	dfs(1);
	cout << cnt - 1; //1번 컴퓨터 제외
}