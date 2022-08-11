#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    queue<int> q;
    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        q.push(i);
    }
    while (q.size() > 1) {
        q.pop();
        q.push(q.front());
        q.pop();
    }
    cout << q.front();
}