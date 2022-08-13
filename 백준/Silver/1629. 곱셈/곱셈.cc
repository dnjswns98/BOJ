#include <iostream>
#define ll long long

using namespace std;

ll mul(int x, int y, int div) {
    if (y == 1)
        return x % div;
    else if (y % 2 == 0) {
        ll tmp = mul(x, y / 2, div);
        return tmp * tmp % div;
    }
    else return x * mul(x, y - 1, div) % div;
}

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    ll a, b, c;
    cin >> a >> b >> c;
    cout << mul(a, b, c);

}