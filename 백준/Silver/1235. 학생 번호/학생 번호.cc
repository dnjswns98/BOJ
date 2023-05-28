#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n;
    cin >> n;   

    string str;
    vector<string> v;
    for (int i = 0; i < n; i++) {
        cin >> str;
        reverse(str.begin(), str.end());
        v.push_back(str);
    }

    int length = 1;
    while (1) {
        set<string> s;

        for (int i = 0; i < v.size(); i++) {
            s.insert(v[i].substr(0, length));
        }

        if (s.size() == n) {
            break;
        }
        
        length++;
    }
    cout << length;
}