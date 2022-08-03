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

void dfs(int idx, int cnt) {
    bool cor = false;
    if (cnt == m) {
        print();
        return;
    }

    for (int i = idx; i < n; i++) {
        if (sel[i] == true)
            continue;
        sel[i] = true;
        tmp.push_back(v[i]);
        dfs(i + 1, cnt + 1); //조합은 순열과 달리 중복이 되면 안되므로 시작점이 필요
        // 다음 cnt로 넘어갈 때 이전에 건든 작은 값은 건들지 않아야하므로 +1씩 증가시킨다
        tmp.pop_back();
        sel[i] = false;
    }
}

int main() {
    cin >> n >> m;
    
    init();
    dfs(0, 0);
}