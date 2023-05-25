#include <iostream>
#include <vector>
using namespace std;

double N, L;

int main() {
    cin >> N >> L;
    for (int i = L; i <= 100; i++) {
        double x = (N - i * (i - 1) / 2) / i;
        if (x - (int)x == 0 && x >= 0) {
            for (int j = x; j < x + i; j++) {
                cout << j << " ";
            }
            return 0;
        }
    }
    cout << -1;
}