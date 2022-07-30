#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    vector<int> v;
    int n;
    cin >> n;
    if (n == 1) {
        int num;
        cin >> num;
        v.push_back(num);
        cout << num * num;
        return 0;
    }
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    cout << v[0] * v[v.size() - 1];
}