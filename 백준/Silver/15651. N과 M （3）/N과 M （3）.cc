#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> v;
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

void dfs(int idx, int cnt) {
    bool cor = false;
    if (cnt == m) {
        print();
        return;
    }

    for (int i = idx; i < n; i++) {
        tmp.push_back(v[i]);
        dfs(0, cnt + 1);
        tmp.pop_back();
    }
}

int main() {
    cin >> n >> m;
    
    init();
    dfs(0, 0);
}