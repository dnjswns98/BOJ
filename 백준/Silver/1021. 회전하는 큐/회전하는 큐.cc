#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);
    
    deque<int> dq;
    int n, m, x;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        dq.push_back(i);
    }

    int cnt = 0;
    for (int i = 0; i < m; i++) {
        cin >> x;
        int idx = 0;
        for (int j = 0; j < n; j++) {
            if (dq[j] == x) {
                idx = j;
                break;
            }
        }
        
        while (1) {
            if (dq.front() == x) {
                dq.pop_front();
                break;
            }
            else if (idx <= dq.size()/2) {
                dq.push_back(dq.front());
                dq.pop_front();
                cnt++;
            }
            else if (idx > dq.size()/2) {
                dq.push_front(dq.back());
                dq.pop_back();
                cnt++;
            }
        }
    }

    cout << cnt;
}