#include <iostream>

using namespace std;
#define MAX 1025
int n, m;
int arr[MAX][MAX] = { 0 };
int dp[MAX][MAX] = { 0 };//ex)dp[2][2] = arr[1][1]+arr[1][2]+arr[2][1]+arr[2][2]

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
            //dp[i-1][j-1]은 중복으로 +된 부분을 빼준다
        }
    }

    int x1, y1, x2, y2;
    for (int i = 1; i <= m; i++) {
        cin >> x1 >> y1 >> x2 >> y2;
        int ans = 0;
        ans = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];

        cout << ans << "\n";
    }
}