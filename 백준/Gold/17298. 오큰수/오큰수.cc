#include <iostream>
#include <stack>
#include <vector>
using namespace std;
//참고 : https://cocoon1787.tistory.com/347

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    stack<int> s;
    int n;
    cin >> n;
    vector<int> v(n);
    vector<int> ans(n);

    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }

    for (int i = n - 1; i >= 0; i--) {
        while (!s.empty() && s.top() <= v[i])
            s.pop();

        if (s.empty())
            ans[i] = -1;
        else ans[i] = s.top();

        s.push(v[i]);
    }

    for (int i = 0; i < n; i++) {
        cout << ans[i] << " ";
    }
}