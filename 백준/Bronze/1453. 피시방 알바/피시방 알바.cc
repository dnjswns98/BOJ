#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n;
    int arr[101] = { 0 };
    cin >> n;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        if (arr[tmp]) {
            cnt++;
        }
        else {
            arr[tmp] = 1;
        }
    }
    cout << cnt;
}