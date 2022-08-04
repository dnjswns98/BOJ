#include <iostream>
#include <vector>
using namespace std;

vector<long long> v;

void P(int n) {
    v = { 0, 1, 1, 1, 2, 2 };
    for (int i = 6; i <= n; i++) {
        long long tmp = v[i - 1] + v[i - 5];
        v.push_back(tmp);
    }
}

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        P(k);
        cout << v[k] << "\n";
    }
}