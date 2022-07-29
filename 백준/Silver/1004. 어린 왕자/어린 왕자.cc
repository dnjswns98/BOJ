#include <iostream>
#include <cmath>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t, n, cnt;
    cin >> t;
    int x1, x2, y1, y2;
    for (int i = 0; i < t; i++) {
        cin >> x1 >> y1 >> x2 >> y2;
        cin >> n;
        cnt = 0;
        for (int i = 0; i < n; i++) {
            int x, y, r;
            cin >> x >> y >> r;
            int d1 = pow((x1 - x), 2) + pow((y1 - y), 2); //출발점
            int d2 = pow((x2 - x), 2) + pow((y2 - y), 2); //도착점
            
            if (d1 < r * r) { //출발지가 행성안
                if (d2 > r * r) //도착지는 행성 밖
                    cnt++;
            }
            else {
                if (d2 < r * r) //도착지를 둘러싼 행성
                    cnt++;
            }
        }
        cout << cnt << "\n";
    }
}