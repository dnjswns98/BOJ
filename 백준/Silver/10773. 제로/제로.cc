#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    stack<int> s;

    int k, tmp, sum = 0;
    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> tmp;
        if (tmp == 0) {
            if (s.empty())
                s.push(tmp);
            else {
                sum -= s.top();
                s.pop();
            }
        }
        else {
            s.push(tmp);
            sum += tmp;
        }
    }
    cout << sum;
}