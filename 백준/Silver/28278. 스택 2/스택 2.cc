#include <iostream>
#include <stack>
using namespace std;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n, m;
    cin >> n;

    stack<int> s;

    while (n--) {
        cin >> m;
        int x;
        switch (m) 
        {
        case 1 :
            cin >> x;
            s.push(x);
            break;
        case 2:
            if (s.empty()) {
                cout << -1 << "\n";
            }
            else {
                cout << s.top() << "\n";
                s.pop();
            }
            break;
        case 3:
            cout << s.size() << "\n";
            break;
        case 4:
            if (s.empty()) {
                cout << 1 << "\n";
            }
            else {
                cout << 0 << "\n";
            }
            break;
        case 5:
            if (s.empty()) {
                cout << -1 << "\n";
            }
            else {
                cout << s.top() << "\n";
            }
        }
        
    }

}