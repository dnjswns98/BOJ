#include <iostream>
#include <deque>
#include <string>
#include <cctype>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);
    
    int t, n;
    cin >> t;
    string p, s;

    for (int i = 0; i < t; i++) {
        cin >> p >> n;
        cin >> s;

        deque<int> dq;
        bool reverse = false;
        bool error = false;
        string num = "";
        for (int j = 0; j < s.length(); j++) {
            if (isdigit(s[j])) {
                num += s[j];
            }
            else {
                if (!num.empty()) {
                    dq.push_back(stoi(num));
                    num = "";
                }
            }
        }

        for (int j = 0; j < p.length(); j++) {
            if (p[j] == 'R') {
                if (reverse)
                    reverse = false;
                else
                    reverse = true;
            }
            else {
                if (dq.empty()) {
                    cout << "error\n";
                    error = true;
                    break;
                }
                if (!dq.empty() && reverse)
                    dq.pop_back();
                else if(!dq.empty() && !reverse) 
                    dq.pop_front();
            }
        }

        if (!error) {
            cout << "[";
            if (reverse && !dq.empty()) {
                for (auto it = dq.rbegin(); it < dq.rend(); it++) {
                    if (it == dq.rend() - 1)
                        cout << *it;
                    else {
                        cout << *it << ",";
                    }
                }
            }
            else if (!reverse && !dq.empty()) {
                for (auto it = dq.begin(); it < dq.end(); it++) {
                    if (it == dq.end() - 1)
                        cout << *it;
                    else {
                        cout << *it << ",";
                    }
                }
            }
            cout << "]\n";
        }
    }
}