#include <iostream>
using namespace std;

int fac(int n, int m) {
    long long ans = 1;
    int r = 1;
    for (int i = m; i > m - n; i--) {
        ans *= i;
        ans /= r;
        r++;
    }
    return ans;
}

int main() {
    int t, n, m;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n >> m;
        cout << fac(n, m) << "\n";
    }
}