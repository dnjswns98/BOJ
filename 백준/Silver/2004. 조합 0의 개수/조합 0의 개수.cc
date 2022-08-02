#include <iostream>
#include <cmath>
using namespace std;

int main() {

    //뒤에서 0이 나오는 경우는 10의 제곱수가 곱해져야 나올수가 있다.
    //따라서 10의 인수인 2,5를 찾으면 된다.
    //2와 5의 갯수를 count 해서 더 적은 갯수를 가진 수를 찾는다.
    //why? 그냥 n!의 경우 1~n까지 5의 갯수가 더 적을테니 5의 수를 따라가면 된다.
    //but 이항계수의 경우 나눠줘야 할 값(m!,(n-m)!)들이 있기 때문에 2의 갯수도 count해서 더 적은 갯수를 가진 수를 따라가줘야한다.
    //EX) 15C3의 경우 5는 1개남지만 2는 0개가 남는다.

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    long long n, m, cnt5 = 0, cnt2 = 0;
    cin >> n >> m;
    for (long long i = 5; i <= n; i*=5) {
        cnt5 += n / i;
    }
    for (long long i = 2; i <= n; i *= 2) {
        cnt2 += n / i;
    }
    for (long long i = 5; i <= m; i *= 5) {
        cnt5 -= m / i;
    }
    for (long long i = 2; i <= m; i *= 2) {
        cnt2 -= m / i;
    }
    for (long long i = 5; i <= n - m; i *= 5) {
        cnt5 -= (n - m) / i;
    }
    for (long long i = 2; i <= n - m; i *= 2) {
        cnt2 -= (n - m) / i;
    }
    cout << min(cnt5,cnt2);
}