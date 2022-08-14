#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    int n, m, k;
    int arr[100][100] = { 0 };
    int arr2[100][100] = { 0 };
    int ans[100][100] = { 0 };

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }

    cin >> m >> k;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < k; j++) {
            cin >> arr2[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            int sum = 0;
            for (int h = 0; h < m; h++) {
                sum += arr[i][h] * arr2[h][j];
            }
            ans[i][j] = sum;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            cout << ans[i][j] << " ";
        }
        cout << "\n";
    }
}