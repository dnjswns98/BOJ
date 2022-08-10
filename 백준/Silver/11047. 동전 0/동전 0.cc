#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, k;
vector<int> v;

bool compare(int a, int b) {
    return a > b;
}

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        if (tmp > k)
            break;
        v.push_back(tmp);
    }

    sort(v.begin(), v.end(), compare); //내림차순으로 정렬

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int div = k / v[i]; //몫이 있다면 몫을 cnt에 +
        if (div == 0)
            continue;
        cnt += div;
        k = k % v[i];
        if (k == 0) //나머지가 없다면 계산 끝
            break;
    }
    cout << cnt;
}