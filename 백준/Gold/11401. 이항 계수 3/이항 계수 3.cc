#include <iostream>
#define ll long long
#define div 1000000007

using namespace std;

//분수의 형태에는 mod가 각각 나눠지는 것이 불가능(분모가 0이 되어버리므로)
//따라서 A/B 형태를 AX형태로 바꿔줘야한다.
//페르마의 소정리를 이용
//p가 소수이고 a가 p의 배수가 아니면, a^(p-1) % p == 1
//A*A^(P-2) % P == 1 이다. 따라서 A^(P-2) % P == A^(-1) 성립한다.
//위 식을 이용하면 (N! / (K! * (N-K)!))%P == N!%P * (K! * (N-K)!)^(P-2) % P 가 성립.
//ex)5C2 = (5 * 4) / (2 * 1) 따라서 a/b %p 형태가 된다. result = (5*4)%p * 2^(p-2)%p

ll mul(ll b, ll n) {
    if (n == 0)
        return 1;
    else if (n == 1)
        return b % div;
    else if (n % 2 == 0) {
        ll tmp = mul(b, n / 2);
        return tmp * tmp % div;
    }
    else
        return b * mul(b, n - 1) % div;
}

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    ll n, k;
    cin >> n >> k;
    ll a = 1;
    for (int i = n; i >= n - k + 1; i--) {
        a *= i;
        a %= div;
    }
    ll b = 1;
    for (int j = 1; j <= k; j++) {
        b *= j;
        b %= div;
    }

    ll result = a * mul(b, div - 2) % div;

    cout << result;
}