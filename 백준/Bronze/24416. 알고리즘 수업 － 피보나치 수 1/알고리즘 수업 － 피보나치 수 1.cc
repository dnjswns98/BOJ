#include <iostream>
using namespace std;

int n, cnt1 = 0, cnt = 0;
int f[41];

int fib(int x) {
    if (x == 1 || x == 2) {
        cnt++;
        return 1;
    }
    else return (fib(x - 1) + fib(x - 2));
}

int fibonacci(int x) {
    f[1] = f[2] = 1;
    for (int i = 3; i <= x; i++) {
        f[i] = f[i - 1] + f[i - 2];
        cnt1++;
    }
    return f[x];
}

int main() {
	cin >> n;
    fib(n);
    fibonacci(n);
    cout << cnt << " " << cnt1;
}