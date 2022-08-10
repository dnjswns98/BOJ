#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    int k;
    cin >> k;
    string s1;
    for (int i = 0; i < k; i++) {
        cin >> s1;

        stack<char> s;
        for (int j = 0; j < s1.length(); j++) {
            if (s.empty() == true || s1[j] == '(')
                s.push(s1[j]);
            else if (s.top() == '(')
                s.pop();
        }
        if (s.empty())
            cout << "YES" << "\n";
        else cout << "NO" << "\n";
    }
}