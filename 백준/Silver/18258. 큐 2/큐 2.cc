#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    queue<int> q;
    int n, tmp;
    cin >> n;

    string s1;
    for (int i = 0; i < n; i++) {
        cin >> s1;
        if (s1.find("push") != string::npos) {
            cin >> tmp;
            q.push(tmp);
        }
        else if (s1 == "pop") {
            if (q.empty())
                cout << -1 << "\n";
            else {
                cout << q.front() << "\n";
                q.pop();
            }
        }
        else if (s1 == "size")
            cout << q.size() << "\n";
        else if (s1 == "empty") {
            if (q.empty())
                cout << 1 << "\n";
            else
                cout << 0 << "\n";
        }
        else if (s1 == "front") {
            if (q.empty())
                cout << -1 << "\n";
            else
                cout << q.front() << "\n";
        }
        else if (s1 == "back") {
            if (q.empty())
                cout << -1 << "\n";
            else
                cout << q.back() << "\n";
        }
    }
}