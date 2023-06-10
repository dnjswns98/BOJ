#include <iostream>
using namespace std;
int main() {
    int n,a[7],sum,min;
    cin >> n;
    while (n--) {
        sum = 0;
        min = 101;
        for (int i = 0; i < 7; i++)
        {
            cin >> a[i];
            if (a[i] % 2 == 0)
            {
                sum += a[i];
                if (a[i] < min)
                    min = a[i];
            }
        }
        cout << sum << ' ' << min<<'\n';
    }
}