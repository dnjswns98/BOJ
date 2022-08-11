#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    stack<int> s;
    int n, x;
    cin >> n;

    string s1 = "";
    int cnt = 1;
    for (int i = 0; i < n; i++) {
        cin >> x;

        while (1) {
            if (x >= cnt) {
                s.push(cnt++);
                s1 += "+";
            }
            else break;
        }

        if (s.top() == x) {
            s.pop();
            s1 += "-";
        }
        else {
            cout << "NO";
            return 0;
        }
    }
    for (int i = 0; i < s1.length(); i++) {
        cout << s1[i] << "\n";
    }
}