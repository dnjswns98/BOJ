#include <iostream>
using namespace std;

int n, a, b;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> n >> a >> b;
    
    int round = 1;
    while (n) {
        if ((a + 1) / 2 == (b + 1) / 2) {
            break;
        }

        a = (a + 1) / 2;
        b = (b + 1) / 2;
        round++;
        n /= 2;
    }
    if (n) {
        cout << round;
    }
    else cout << -1;
}