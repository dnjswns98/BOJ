#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<long long> km;
vector<long long> price;

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n;
    int tmp;
    for (int i = 0; i < n - 1; i++) {
        cin >> tmp;
        km.push_back(tmp);
    }
    for (int i = 0; i < n; i++) {
        cin >> tmp;
        price.push_back(tmp);
    }

    long long minPrice = 1000000000;
    long long sum = 0;
    for (int i = 0; i < n - 1; i++) {
        minPrice = min(minPrice, price[i]);
        sum += minPrice * km[i];
    }
    cout << sum;
}