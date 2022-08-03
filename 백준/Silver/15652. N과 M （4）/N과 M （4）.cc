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
    if (cnt == m) {
        print();
        return;
    }

    for (int i = idx; i < n; i++) {
        tmp.push_back(v[i]);
        dfs(i, cnt + 1); //이전 인덱스를 기억해서 이전인덱스부터 시작한다
        //{2 2 ?} ?는 이전 인덱스인 2부터 시작을해서 2, 3, 4 ~ 가 들어가고 1은 들어가지 않는다.
        tmp.pop_back();
    }
}

int main() {
    cin >> n >> m;
    
    init();
    dfs(0, 0);
}