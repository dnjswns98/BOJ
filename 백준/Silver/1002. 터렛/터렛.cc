#include <iostream>
#include <cmath>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t, d, cnt = 0;
    cin >> t;
    int x1, x2, y1, y2, r1, r2;
    for (int i = 0; i < t; i++) {
        cnt = 0;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        d = pow((x1 - x2), 2) + pow((y1 - y2), 2);
        if (d == 0) //동심원
        {
            if (r1 - r2 == 0) //반지름이 같은 원
                cnt--;
            else
                cnt = 0;
        }
        else if (d == pow((r1 + r2), 2) || d == pow((r1 - r2), 2)) //내접과 외접
        {
            cnt++;
        }
        else if (d > pow((r1 - r2), 2) && d < pow((r1 + r2), 2)) //접점2개
        {
            cnt = 2;
        }
        else cnt = 0;

        cout << cnt << "\n";
    }
}