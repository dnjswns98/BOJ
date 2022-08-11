#include <iostream>
#include <queue>
using namespace std;
//참고 : https://numerok.tistory.com/134

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    int t, n, m, ipt;
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> n >> m;

        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int j = 0; j < n; j++) {
            cin >> ipt;
            pq.push(ipt);
            q.push(make_pair(j,ipt));
        }
        int cnt = 0;
        while (!q.empty()) {
            int idx = q.front().first;
            int val = q.front().second;
            if (pq.top() == val) {
                pq.pop();
                q.pop();
                cnt++;
                if (idx == m) {
                    cout << cnt << "\n";
                    break;
                }
            }
            else {
                q.push(make_pair(idx, val));
                q.pop();
            }
        }
        
    }
}