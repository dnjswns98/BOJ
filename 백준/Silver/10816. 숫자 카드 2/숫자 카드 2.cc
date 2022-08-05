#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;



int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> map;

    int n, m, tmp;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> tmp;
        map.push_back(tmp);
    }
    sort(map.begin(), map.end());

    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> tmp;
        cout << upper_bound(map.begin(), map.end(), tmp) - lower_bound(map.begin(), map.end(), tmp) << " ";
    }
}