#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int n, m;
int arr[50][50];

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < m; j++) {
            arr[i][j] = s[j] - '0';
        }
    }

    int cnt = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            for (int k = 1; k < min(n, m); k++) {
                if (i + k < n && j + k < m && arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i + k][j + k] && arr[i][j] == arr[i][j + k])
                    cnt = max(cnt, k + 1);
            }
        }
    }
    cout << cnt * cnt;
}