#include <iostream>
#include <cmath>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int r;
    const double PI = std::acos(-1);
    cin >> r;
    cout << fixed;
    cout.precision(6);
    cout << (double)r * r * PI << "\n" << (double)r * r * 2.0;
}