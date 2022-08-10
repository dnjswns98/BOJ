#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<pair<int, int>> v;

bool compare(pair<int, int>a, pair<int, int>b) { //끝나는 시간을 기준으로 오름차순 정렬
    if (a.second == b.second) {
        return a.first < b.first;  //끝나는 시간이 같다면 시작하는값을 기준으로 오름차순 정렬
        //이렇게 하지 않을 시 ex) (1,3)(8,8)(4,8)이 나왔을 때 출력값이 다를 수 있음
    }
    return a.second < b.second;
}

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int start, finish;
        cin >> start >> finish;
        v.push_back(make_pair(start, finish));
    }
    sort(v.begin(), v.end(), compare);

    int start = v[0].second;
    int cnt = 1;
    for (int i = 1; i < n; i++) {
        if (start <= v[i].first) {
            cnt++;
            start = v[i].second;
        }
    }
    cout << cnt;
}