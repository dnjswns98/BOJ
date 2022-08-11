#include <iostream>
#include <queue>
#include <string>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    queue<int> q;
    int n, k;
    cin >> n >> k;
    vector<int> v(n);
    for (int i = 1; i <= n; i++) {
        q.push(i);
    }
    int cnt = 1;
    int i = 0;
    while (1) {
        if (!q.empty() && cnt % k == 0) {
            v[i] = q.front();
            q.pop();
            i++;
        }
        else if(!q.empty() && cnt % k != 0){
            q.push(q.front());
            q.pop();
        }
        if (q.empty())
            break;
        cnt++;
    }
    cout << "<";
    for (int i = 0; i < n; i++) {
        if (i == n - 1)
            cout << v[i];
        else cout << v[i] << ", ";
    }
    cout << ">";
}