#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <vector>
using namespace std;
void fast_io(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}
bool cmp(pair<string, int> &a, pair<string, int> &b)
{
    if (a.second==b.second)
    {
        if (a.first.length()==b.first.length())
            return a.first < b.first;
        return a.first.length() > b.first.length();
    }
    return a.second > b.second;
}
int n, m;
unordered_map<string, int> v;
int main(void)
{
    fast_io();
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        string str;
        cin >> str;
        if (str.length() >= m)
            v[str]++;
    }
    vector<pair<string, int>> vec(v.begin(), v.end());
    sort(vec.begin(), vec.end(),cmp);
    for (auto p : vec)
        cout << p.first << "\n";
}