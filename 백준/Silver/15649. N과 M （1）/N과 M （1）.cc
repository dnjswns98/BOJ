#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> v;
bool sel[8] = {0, };
vector<int> tmp;

void init() {
    for (int i = 0; i < n; i++) {
        v.push_back(i+1);
    }
}

void print() {
    for (int i = 0; i < m; i++) {
        cout << tmp[i] << " ";
    }
    cout << "\n";
}

void dfs(int cnt) {
    if (cnt == m) {
        print();
        return;
    }

    for (int i = 0; i < n; i++) {
        if (sel[i] == true)
            continue;
        sel[i] = true;
        tmp.push_back(v[i]);
        dfs(cnt + 1);
        tmp.pop_back();
        sel[i] = false;
    }
}

int main() {
    cin >> n >> m;
    
    init();
    dfs(0);
}