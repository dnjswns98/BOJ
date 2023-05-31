#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n, k;
    int chicken = 0, stamp = 0;
    while (cin >> n >> k) {
        chicken = 0, stamp = 0;

        while (1) {
            chicken += n;
            stamp += n;

            n = 0;
            n += stamp / k;
            stamp %= k;

            if (n == 0) break;
        }
        cout << chicken << "\n";
    }
}