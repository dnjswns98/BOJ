#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    stack<int> s;

    int n, tmp;
    cin >> n;
    
    string s1;
    for (int i = 0; i < n; i++) {
        cin >> s1;
        if (s1.find("push") != string::npos) {
            cin >> tmp;
            s.push(tmp);
        }
        else if (s1 == "pop") {
            if (s.empty())
                cout << -1 << "\n";
            else {
                cout << s.top() << "\n";
                s.pop();
            }     
        }
        else if (s1 == "size") 
            cout << s.size() << "\n";
        else if (s1 == "empty") {
            if (s.empty())
                cout << 1 << "\n";
            else
                cout << 0 << "\n";
        }
        else if (s1 == "top") {
            if (s.empty())
                cout << -1 << "\n";
            else
                cout << s.top() << "\n";
        }
    } 
}