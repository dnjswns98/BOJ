#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    string s1;
    while (1) {
        getline(cin, s1);
        if (s1.length() == 1 && s1[0] == '.') return 0;

        stack<char> s;
        for (int j = 0; j < s1.length(); j++) {
            if (s1[j] == '[' || s1[j] == '(')
                s.push(s1[j]);
            else if (s.empty() && s1[j] == ')')
                s.push(s1[j]);
            else if (s.empty() && s1[j] == ']')
                s.push(s1[j]);
            else if (!s.empty() && s.top() == '[' && s1[j] == ']')//empty검사를 하지않으면 오류가 남. 반드시 empty를 제일 먼저 검사해야함
                s.pop();
            else if (!s.empty() && s.top() == '(' && s1[j] == ']')
                s.push(s1[j]);
            else if (!s.empty() && s.top() == '(' && s1[j] == ')')
                s.pop();
            else if (!s.empty() && s.top() == '[' && s1[j] == ')')
                s.push(s1[j]);
        }
        if (s.empty())
            cout << "yes" << "\n";
        else cout << "no" << "\n";
        while (!s.empty()) s.pop();
    }
}
   