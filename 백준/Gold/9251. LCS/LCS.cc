#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string s1, s2;
int dp[1001][1001] = { 0 };
/*
dp[i][j]
  0 A C A Y K P
0 0 0 0 0 0 0 0
C 0 0 1 1 1 1 1
A 0 1 1 2 2 2 2
P 0 1 1 2 2 2 3
C 0 1 2 2 2 2 3
A 0 1 2 3 3 3 3
K 0 1 2 3 3 4 4
*/

int main() {
    cin >> s1 >> s2;

    for (int i = 1; i <= s1.size(); i++) {
        for (int j = 1; j <= s2.size(); j++) {
            if (s1[i - 1] == s2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
        }
    }
    cout << dp[s1.size()][s2.size()];
}