#include <iostream>
#include <cmath>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int w, h, x, y, p, cnt = 0;
    cin >> w >> h >> x >> y >> p;
    int x1, y1;
    int r = h / 2;
    for (int i = 0; i < p; i++) {
        cin >> x1 >> y1;
        int d1 = pow((x1 - x), 2) + pow((y1 - (r + y)), 2); //하키의 왼쪽 반원
        int d2 = pow((x1 - (x + w)), 2) + pow((y1 - (r + y)), 2);
        if (x1 < x) { //왼쪽 반원에 있는지 검사
            if (d1 <= r * r)
                cnt++;
        }
        else if (x1 > x + w) {
            if (d2 <= r * r)
                cnt++;
        }
        else if (x1 <= w + x && x1 >= x) { //직사각형 안에 들어있는지
            if (y1 <= h + y && y1 >= y) {
                cnt++;
            }
        }
    }
    cout << cnt;
}