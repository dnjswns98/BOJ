#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int mod(int a, int b) {
    if (a % b == 0)
        return b;
    else
        return mod(b, a % b);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    vector<int> v;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());

    int gcd = v[1] - v[0];

    for (int i = 2; i < n; i++) {
        gcd = mod(gcd, v[i] - v[i - 1]);
    }

    vector<int> result;
    for (int i = 2; i * i <= gcd; i++)
    {
        if (gcd % i == 0)
        {
            result.push_back(i);
            result.push_back(gcd / i);
        }
    }
    result.push_back(gcd);
    sort(result.begin(), result.end());
    result.erase(unique(result.begin(), result.end()), result.end());

    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << " ";
    }
}
