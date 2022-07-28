#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    pair<int, int> p[6];
    int k;
    cin >> k;
    for (int i = 0; i < 6; i++) {
        int a, b;
        cin >> p[i].first >> p[i].second;
    }

    int tmp = 0;
    int area;
    for (int i = 0; i < 6; i++) {
        int cur = p[i].second * p[(i + 1) % 6].second;
        if (cur > tmp) {
            tmp = cur;
            area = (cur - (p[(i + 3) % 6].second * p[(i + 4) % 6].second)) * k;
        }
    }

    cout << area;
}