#include <iostream>
#define ll long long
using namespace std;

//참고 : https://cocoon1787.tistory.com/293

ll n, b;
ll a[5][5] = { 0 };
ll ans[5][5] = { 0 };

void print() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << ans[i][j] << " ";
        }
        cout << "\n";
    }
    cout << endl;
}

void res(ll x[5][5], ll y[5][5]) {
    ll sum[5][5] = { 0 };
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++)
                sum[i][j] += (x[i][k] * y[k][j]) % 1000;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            x[i][j] = sum[i][j] % 1000;
}

void pow() {
    while (b > 0) {
        if (b % 2 == 1)
            res(ans, a);
        res(a, a);
        b /= 2;
    }
}

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n >> b;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
        ans[i][i] = 1;
    }
    
    pow();
    print();
}