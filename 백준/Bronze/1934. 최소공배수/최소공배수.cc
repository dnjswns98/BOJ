#include <iostream>
using namespace std;

int mod(int a, int b) {
    if (a % b == 0)
        return b;
    else
        return mod(b, a % b);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t, a, b;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> a >> b;
        int n = mod(a, b);
        int m = a * b / n;
        cout << m << "\n";
    }
}