#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

//전깃줄이 서로 교차하면 안되므로 첫번째값의 연결된 줄보다 두번째줄의 결과값은 항상 커야한다.
//ex) 1->7, 2->8, 3->9
//그러니 첫번째값을 기준으로 오름차순으로 정렬을 해준다.
//교차하는 전깃줄을 삭제하는 방법이 아닌 최대의 전깃줄 연결 방법을 생각한다.
//최장길이의 오름차순 결과값을 구하면 된다.
//설치한 전깃줄(n) - 최장길이(LIS) = 최소로 제거해야할 전깃줄

int n;
int dp[101];
vector<pair<int,int>> v;

int main() {
    cin >> n;
 
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        v.push_back(make_pair(a, b));
    }
    sort(v.begin(), v.end());

    fill_n(dp, 100, 1);

    int sumMax = 0;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (v[i].second > v[j].second && dp[i] < dp[j] + 1)
                dp[i] = dp[j] + 1;
        }
        if (sumMax < dp[i])
            sumMax = dp[i];
    }

    cout << n - sumMax; 
}