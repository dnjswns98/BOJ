#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n;
    cin >> n;

    stack<int> s;
    queue<int> q;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        q.push(num); //    //5 3 4
    }
    int cnt = 1;
    while (1) {
        if (!q.empty()) {
            if (q.front() != cnt) {
                if (s.empty()) {
                    s.push(q.front());
                    q.pop();
                }
                else {
                    if (s.top() == cnt) {
                        s.pop();
                        cnt++;
                    }
                    else {
                        s.push(q.front());
                        q.pop();
                    }
                }
            }
            else {
                cnt++;
                q.pop();
            }
        }
        else {
            if (s.empty()) {
                cout << "Nice";
                return 0;
            }
            else {
                if (s.top() == cnt) {
                    s.pop();
                    cnt++;
                }
                else {
                    cout << "Sad";
                    return 0;
                }
            }
        }
    }
}