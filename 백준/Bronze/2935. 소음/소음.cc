#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
using namespace std;
int main() {
    string a="", b="", c;
    cin >> a >> c >> b;
    if (c == "+")
    {
        int size = max(a.size(), b.size());
        int tmp = a.size() - b.size();
        string plus = "";
        if (tmp < 0) //b.size()가 더 큰 경우
        {
            for (int i = 0; i < abs(tmp); i++)//abs()절대값 반환 함수
                plus += "0";
            a = plus + a;
        }
        else//a.size()가 더 큰 경우
        {
            for (int i = 0; i < abs(tmp); i++)
                plus += "0";
            b = plus + b;
        }
        for (int i = size-1; i >= 0; i--)
        {
            if(b[i]-'0')
                a[i] = ((a[i] - '0') + (b[i] - '0')) + '0';
        }
        cout << a;
    }
    else
    {
        int size = a.size() - 1 + b.size() - 1;
        cout << "1";
        while(size--)
            cout << 0;
    }
}
