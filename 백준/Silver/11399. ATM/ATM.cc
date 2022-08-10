#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> v;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }
    sort(v.begin(), v.end());

    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (i > 0)
            v[i] = v[i - 1] + v[i];
        sum += v[i];
    }
    cout << sum;
}