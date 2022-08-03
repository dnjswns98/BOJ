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
    bool cor = false;
    if (cnt == m) {
        if (m > 1) { //출력해야할 수가 2개이상일때 순서에 상관없이 중복을 제거해야한다. ex){1 2}출력 후 {2 1}은 불가능하다
            for (int i = 0; i < m - 1; i++) { //오름차순으로 중복없이 출력을 해야하니 값들을 비교하여 tmp[i]값보다 tmp[i+1]값이 작다면 중복이다. ex){1 2} {2 1}
                if (tmp[i] < tmp[i + 1])
                    cor = true;
                else {
                    cor = false;
                    break;
                }
            }
            if (cor)
                print();
        }
        else print();
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