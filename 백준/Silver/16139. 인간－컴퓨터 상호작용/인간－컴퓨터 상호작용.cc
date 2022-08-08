#include <iostream>
#include <string>
using namespace std;

string s;
char c;
int q, l, r;
int dp[200000][26] = { 0 }; //string s의 길이와 알파벳

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);
    cin >> s >> q;

    dp[0][s[0] - 97] = 1; //dp[0][] = s[0]의 알파벳+1
    for (int i = 1; i < s.size(); i++) {
        for (int j = 0; j < 26; j++) {
            dp[i][j] = dp[i - 1][j];
        }
        dp[i][s[i] - 97]++;
    }

    for (int i = 0; i < q; i++) {
        cin >> c >> l >> r;
        int found = c - 97;
        if (l > 0)
            cout << dp[r][found] - dp[l - 1][found] << "\n";
        else
            cout << dp[r][found] << "\n";
    }

}