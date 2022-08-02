#include <iostream>
#include <map>
using namespace std;

int main() {

    //ex) face종류 2개, eyegear종류 1개가 있다면 face종류에서 고를 수 있는 선택지는 총 3가지(face 1, face 2, x)다.
    //    eyegear역시 고를 수 있는 경우의 수는 2.
    //    따라서 3*2에서 알몸인 상태, 즉 아무것도 선택하지 않은 경우의 수 1을 빼주게 되면 3*2-1 = 5가 된다.

    int t, n;
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> n;
        map<string, int> ms;
        for (int j = 0; j < n; j++) {
            string s, key;
            cin >> s >> key;
            ms[key]++;
        }
        int ans = 1;
        for (auto it = ms.begin(); it != ms.end(); it++) {
            ans *= (it->second + 1);
        }
        cout << ans - 1 << "\n";
    }
}