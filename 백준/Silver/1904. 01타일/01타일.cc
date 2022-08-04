#include <iostream>
#include <vector>
using namespace std;

vector<int> v = {0, 1, 2};

void fuc(int n) {
    for (int i = 3; i <= n; i++) {
        int tmp = (v[i - 1] + v[i - 2]) % 15746;
        v.push_back(tmp);
    }
}

int main() {
    int n;
    cin >> n;
    fuc(n);
    cout << v[n];
}