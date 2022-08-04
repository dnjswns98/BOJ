#include <iostream>
#include <algorithm>
using namespace std;

int arr[500][500] = { 0 };

int main() {
    int n, maxSum = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            cin >> arr[i][j];
        }
    }
    maxSum = arr[0][0]; //초기화하지 않으면 n=1일 때 오류가 생김
    for (int i = 1; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            if (j == 0)
                arr[i][j] += arr[i - 1][0];
            else if (j == i)
                arr[i][j] += arr[i - 1][j - 1];
            else if (j > 0 && j < i)
                arr[i][j] += max(arr[i - 1][j - 1], arr[i - 1][j]);

            maxSum = max(maxSum, arr[i][j]);
        }
    }
    cout << maxSum;
}