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

    for (int i = 1; i < n; i++) {
       int gcd = mod(v[0], v[i]);
       cout << v[0] / gcd << "/" << v[i] / gcd << "\n";
    }
}